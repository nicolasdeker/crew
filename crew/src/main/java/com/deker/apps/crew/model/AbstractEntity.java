package com.deker.apps.crew.model;

public abstract class AbstractEntity {

		// the Entity unique identifier
		public UniqueIdentifier identifier;
		// the Entity name
		public String name;

		public AbstractEntity(String name, UniqueIdentifier identifier){
			this.name = name;
			this.identifier = identifier;
		}
}
