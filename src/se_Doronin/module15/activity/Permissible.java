package se_Doronin.module15.activity;

import java.util.Set;

public interface Permissible {

	/**
	 * Sets the permission provided the Permissions passed as parameters
	 * 
	 * @param permissions
	 */
	public void setPermission(Permission...permissions);
	
	
	/**
	 * Removes the permissions specified in the parameters
	 * 
	 * @param permissions
	 */
	public void removePermission(Permission...permissions);
	
	
	/**
	 * Returns collection of permissions
	 *
	 * @return
	 */
	public Set<Permission>getPermission();

	/**
	 * Checks if passed permission acceptable
	 * @param permission
	 * @return
	 */
	public boolean isPermissible(Permission permission);
}
