package com.deker.apps.crew.model.entities.crew;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.util.Assert;

import com.deker.apps.crew.model.AbstractEntity;
import com.deker.apps.crew.model.UniqueIdentifier;
import com.deker.apps.crew.model.entities.Member;
import com.deker.apps.crew.model.entities.Power;
import com.deker.apps.crew.model.entities.Role;

/**
 * A <i>Crew</i> is made of {@link Member}s.
 * <ul>
 * <li>In a Crew, each {@link Member} has a unique {@link Role}</li>
 * <li>In a Crew, each {@link Role} provides a set of {@link Power}s
 * <li>
 * 
 * @author nicolasdeker
 * 
 */
public class Crew extends AbstractEntity {

	// the Crew guys and their respective Title
	private Map<Member, Role> membersRole;
	// the Titles and their respective Powers
	private Map<Role, Collection<Power>> rolesPowers;

	public Crew(String name, UniqueIdentifier identifier) {
		super(name, identifier);
		this.membersRole = new HashMap<Member, Role>();
		this.rolesPowers = new HashMap<Role, Collection<Power>>();
	}

	/**
	 * Hire a new {@link Member} in the {@link Crew} with a {@link Role}
	 * 
	 * @param member
	 *            The {@link Member} to hire
	 * @param role
	 *            The {@link Role} given to the {@link Member} in the {@link Crew}
	 */
	public void hire(Member member, Role role)  {
		Assert.notNull(member, "A Member cannot be null");
		Assert.notNull(role, "Every Member needs a Role.");
		//
		this.membersRole.put(member, role);
		//
		if (!this.rolesPowers.containsKey(role))
			this.rolesPowers.put(role, new ArrayList<Power>());
	}

	public void fire(Member member) {
		if (this.membersRole.containsKey(member))
			this.membersRole.remove(member);
	}


	public Collection<Member> memberWithRole(Role role) {
		Collection<Member> members = new HashSet<Member>();
		//
		for (Member member : this.membersRole.keySet())
			if (this.membersRole.get(member).equals(role))
				members.add(member);
		//
		return members;
	}

}
