package services;

import annotations.*;
import types.*;

@Service
@Area("Virtualization")
public interface VmService extends MeasurableService{
	
	/**
	 * This operation stops any migration of a virtual machine to another physical host.
	  * 
	  * [source]
	  * ----
	  * POST /ovirt-engine/api/vms/123/cancelmigration
	  * ----
	  * 
	  * The cancel migration action does not take any action specific parameters,
	  * so the request body should contain an empty `action`:
	  * 
	  * [source,xml]
	  * ----
	  * <action/>
	  * ----
	 *
	 * @author Arik Hadas <ahadas@redhat.com>
	 * @date 14 Sep 2016
	 * @status added
	 */
	interface CancelMigration {
	   
	   /**
	    * Indicates if the migration should cancelled asynchronously.
	    */
	   @In Boolean async();
	}
	
	interface CommitSnapshot {
	   
	   /**
	    * Indicates if the snapshots should be committed asynchronously.
	    */
	   @In Boolean async();
	}
	
	interface Clone {
	   
	   @In Vm vm();
	   
	   /**
	    * Indicates if the clone should be performed asynchronously.
	    */
	   @In Boolean async();
	}
	
	/**
	 * Detaches a virtual machine from a pool.
	  * 
	  * [source]
	  * ----
	  * POST /ovirt-engine/api/vms/123/detach
	  * ----
	  * 
	  * The detach action does not take any action specific parameters, so the request body should contain an
	  * empty `action`:
	  * 
	  * [source,xml]
	  * ----
	  * <action/>
	  * ----
	 *
	 * @author Arik Hadas <ahadas@redhat.com>
	 * @date 14 Sep 2016
	 * @status added
	 */
	interface Detach {
	   
	   /**
	    * Indicates if the detach should be performed asynchronously.
	    */
	   @In Boolean async();
	}
	
	/**
	 * Export a virtual machine to an export domain.
	  * 
	  * [source]
	  * ----
	  * POST /ovirt-engine/api/vms/123/export
	  * ----
	  *      
	  * With a request body like this:
	  *      
	  * [source,xml]
	  * ----
	  * <action>
	  *  <storage_domain>
	  *   <name>myexport</name>
	  *  </storage_domain>
	  *  <exclusive>true</exclusive>
	  *  <discard_snapshots>true</discard_snapshots>
	  * </action>
	  * ----
	 *
	 * @author Tal Nisan <tisan@redhat.com>
	 * @date 19 Sep 2016
	 * @status added
	 */
	interface Export {
	   
	   /**
	    * The `discard_snapshots` parameter is to be used when the virtual machine should be exported with all its snapshots collapsed.
	    *
	    * @author Tal Nisan <tisan@redhat.com>
	    * @date 19 Sep 2016
	    * @status added
	    */
	   @In Boolean discardSnapshots();
	   
	   /**
	    * The `exclusive` parameter is to be used when the virtual machine should be exported even if another copy of it already exists in the export domain (override).
	    *
	    * @author Tal Nisan <tisan@redhat.com>
	    * @date 19 Sep 2016
	    * @status added
	    */
	   @In Boolean exclusive();
	   
	   @In StorageDomain storageDomain();
	   
	   /**
	    * Indicates if the export should be performed asynchronously.
	    */
	   @In Boolean async();
	}
}
