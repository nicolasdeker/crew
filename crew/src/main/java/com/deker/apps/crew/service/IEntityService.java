package com.deker.apps.crew.service;

import java.util.Set;

import com.deker.apps.crew.entity.Entity;
import com.deker.apps.crew.entity.identifier.UniqueIdentifier;
import com.deker.apps.crew.service.exception.EntityAlreadyExistsException;
import com.deker.apps.crew.service.exception.EntityNotFoundException;

public interface IEntityService<T extends Entity> {

	/**
	 * Get {@link UniqueIdentifier}s of all {@link Entity}s, or an empty
	 * {@link Set} if no {@link Entity} can be found.
	 * 
	 * @return {@link UniqueIdentifier}s of all {@link Entity}s
	 */
	public Set<UniqueIdentifier> list();

	/**
	 * Get all {@link Entity}s, or an empty {@link Set} if no {@link Entity} can
	 * be found.
	 * 
	 * @return all {@link Entity}s
	 */
	public Set<T> get();

	/**
	 * Get the {@link Entity} with the given {@link UniqueIdentifier}.
	 * 
	 * @param identifier
	 *            The {@link UniqueIdentifier} of the {@link Entity}
	 * @return the {@link Entity} with the given {@link UniqueIdentifier}
	 */
	public T get(UniqueIdentifier identifier) throws EntityNotFoundException;

	/**
	 * Create the {@link Entity}.
	 * 
	 * @param entity
	 *            the {@link Entity} to create
	 * @throws EntityAlreadyExistsException
	 *             if the {@link Entity} already exists
	 */
	public void post(Entity entity) throws EntityAlreadyExistsException;

	/**
	 * Replace the {@link Entity}.
	 * 
	 * @param entity
	 *            the {@link Entity} to replace
	 * @throws EntityNotFoundException
	 *             if no existing {@link Entity} can be found
	 */
	public void put(Entity entity) throws EntityNotFoundException;

	/**
	 * Delete the {@link Entity} with the given {@link UniqueIdentifier}.
	 * 
	 * @param identifier
	 *            the {@link Entity} to delete
	 * @throws EntityNotFoundException
	 *             if no existing {@link Entity} can be found
	 */
	public void delete(UniqueIdentifier identifier)
			throws EntityNotFoundException;

}
