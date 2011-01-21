/*
 * This file is part of Elios.
 *
 * Copyright 2010 Jeremie GASTON-RAOUL & Alexandre COLLIGNON
 *
 * Elios is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Elios is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Elios. If not, see <http://www.gnu.org/licenses/>.
 */

package net.eliosoft.elios.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A manager for the cues
 *  
 * @author Jeremie GASTON-RAOUL
 */
public class CuesManager {
	private Map<String, Cue> cuesMap = new HashMap<String, Cue>();
	private static CuesManager instance;
	
	private CuesManager(){}
	
	/**
	 * get the singleton instance of the CuesManager
	 * @return the instance
	 */
	public static CuesManager getInstance(){
		if(instance == null){
			instance = new CuesManager();
		}
		return instance;
	}

	/**
	 * add a cue in the manager
	 * @param cue the cue to add to the manager
	 */
	public void addCue(Cue cue){
		if(cuesMap.containsKey(cue.getName())){
			throw new IllegalArgumentException("a cue with this name is already set");
		}
		else{
			cuesMap.put(cue.getName(), cue);
		}
	}
	
	/**
	 * remove the requested cue
	 * @param name the name of the cue to remove
	 */
	public void removeCue(String name){
		cuesMap.remove(name);
	}
	
	/**
	 * get the cue with the requested name
	 * @param name
	 * @return the requested cue if found or null if no cue is found
	 */
	public Cue getCue(String name){
		return cuesMap.get(name);
	}

	/**
	 * get all the cues of the manager
	 * @return a list containing the cues
	 */
	public List<Cue> getCues(){
		return new ArrayList<Cue>(cuesMap.values());
	}
}