package com.deker.apps.crew.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.util.Assert;

import com.deker.apps.crew.entity.exception.GuyNotInCrewException;
import com.deker.apps.crew.entity.exception.RoleNotInCrewException;
import com.deker.apps.crew.entity.identifier.UniqueIdentifier;

/**
 * A <i>Crew</i> is made of {@link Guy}s.
 * <ul>
 * <li>In a Crew, each {@link Guy} has a unique {@link Role}</li>
 * <li>In a Crew, each {@link Role} provides a set of {@link Power}s
 * <li>
 * 
 * @author nicolasdeker
 * 
 */
public class Crew extends Entity {

	// the Crew guys and their respective Title
	private Map<Guy, Role> guysRole;
	// the Titles and their respective Powers
	private Map<Role, Set<Power>> rolesPowers;

	public Crew(String name, UniqueIdentifier identifier) {
		super(name, identifier);
		this.guysRole = new HashMap<Guy, Role>();
		this.rolesPowers = new HashMap<Role, Set<Power>>();
	}

	/**
	 * Add a {@link Guy} in the {@link Crew} with a {@link Role}. If the
	 * {@link Guy} already belongs to the {@link Crew}, he acquires the new
	 * {@link Role}.
	 * 
	 * @param guy
	 *            The {@link Guy} to hire
	 * @param role
	 *            The {@link Role} given to the {@link Guy} in the {@link Crew}
	 */
	public void hire(Guy guy, Role role) {
		if (guy == null || role == null)
			return;
		//
		this.guysRole.put(guy, role);
		//
		if (!this.rolesPowers.containsKey(role))
			this.rolesPowers.put(role, new HashSet<Power>());
	}

	/**
	 * Remove a {@link Guy} from the {@link Crew}. If the {@link Guy} does not
	 * belong to the {@link Crew}, nothing happens.
	 * 
	 * @param guy
	 *            The {@link Guy} to remove
	 */
	public void fire(Guy guy) {
		if (guy != null && this.guysRole.containsKey(guy))
			this.guysRole.remove(guy);
	}

	public void grant(Power power, Guy guy) {
		if (guy != null && this.guysRole.containsKey(guy))
			grant(power, this.guysRole.get(guy));
	}

	public void grant(Power power, Role role) {
		if (power != null && role != null && this.rolesPowers.containsKey(role)
				&& !this.rolesPowers.get(role).contains(power))
			this.rolesPowers.get(role).add(power);
	}

	public void revoke(Power power, Guy guy) {
		if (guy != null && this.guysRole.containsKey(guy))
			revoke(power, this.guysRole.get(guy));
	}

	public void revoke(Power power, Role role) {
		if (power != null && role != null && this.rolesPowers.containsKey(role)
				&& this.rolesPowers.get(role).contains(power))
			this.rolesPowers.get(role).remove(power);
	}

}
