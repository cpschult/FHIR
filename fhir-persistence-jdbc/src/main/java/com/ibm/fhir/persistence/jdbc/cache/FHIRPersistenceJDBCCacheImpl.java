/*
 * (C) Copyright IBM Corp. 2020, 2021
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.fhir.persistence.jdbc.cache;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

import com.ibm.fhir.persistence.jdbc.FHIRPersistenceJDBCCache;
import com.ibm.fhir.persistence.jdbc.dao.api.ICommonTokenValuesCache;
import com.ibm.fhir.persistence.jdbc.dao.api.INameIdCache;

/**
 * Aggregates and manages the individual caches used for a tenant
 */
public class FHIRPersistenceJDBCCacheImpl implements FHIRPersistenceJDBCCache {
    private static final Logger logger = Logger.getLogger(FHIRPersistenceJDBCCacheImpl.class.getName());

    private final INameIdCache<Integer> resourceTypeCache;

    private final INameIdCache<Integer> parameterNameCache;

    private final ICommonTokenValuesCache resourceReferenceCache;

    // flag to allow one lucky caller to get the opportunity to prefill
    private final AtomicBoolean needToPrefillFlag = new AtomicBoolean(true);

    /**
     * Public constructor
     * @param resourceTypeCache
     * @param parameterNameCache
     * @param resourceReferenceCache
     */
    public FHIRPersistenceJDBCCacheImpl(INameIdCache<Integer> resourceTypeCache, INameIdCache<Integer> parameterNameCache, ICommonTokenValuesCache resourceReferenceCache) {
        this.resourceTypeCache = resourceTypeCache;
        this.parameterNameCache = parameterNameCache;
        this.resourceReferenceCache = resourceReferenceCache;
    }

    /**
     * @return the resourceReferenceCache
     */
    public ICommonTokenValuesCache getResourceReferenceCache() {
        return resourceReferenceCache;
    }

    @Override
    public INameIdCache<Integer> getResourceTypeCache() {
        return this.resourceTypeCache;
    }

    /**
     * @return the parameterNameCache
     */
    public INameIdCache<Integer> getParameterNameCache() {
        return parameterNameCache;
    }

    @Override
    public void transactionCommitted() {
        logger.fine("Transaction committed - updating cache shared maps");
        resourceTypeCache.updateSharedMaps();
        parameterNameCache.updateSharedMaps();
        resourceReferenceCache.updateSharedMaps();
    }

    @Override
    public void transactionRolledBack() {
        logger.fine("Transaction rolled back - clearing local maps");
        resourceTypeCache.clearLocalMaps();
        parameterNameCache.clearLocalMaps();
        resourceReferenceCache.clearLocalMaps();
    }

    @Override
    public boolean needToPrefill() {
        // should return true only ever once
        return needToPrefillFlag.getAndSet(false);
    }
}