package com.deker.apps.crew.entity;

import com.deker.apps.crew.entity.identifier.UniqueIdentifier;

public abstract class Entity {

		// the Entity unique identifier
		public UniqueIdentifier identifier;
		// the Entity name
		public String name;

		public Entity(String name, UniqueIdentifier identifier){
			this.name = name;
			this.identifier = identifier;
		}
}
