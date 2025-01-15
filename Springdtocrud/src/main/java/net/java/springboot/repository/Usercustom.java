package net.java.springboot.repository;

import java.util.List;

import net.java.springboot.entity.Userentity;

public interface Usercustom {
	
	List<Userentity> findUsersByText(String searchText,String city);

}
