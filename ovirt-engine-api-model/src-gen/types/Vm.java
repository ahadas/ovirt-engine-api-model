package types;

import java.util.*;
import org.ovirt.api.metamodel.annotations.*;

@Type
public interface Vm extends VmBase{
  
  VmStatus status();
  
  String statusDetail();
  
  String stopReason();
  
  Date startTime();
  
  Date stopTime();
  
  Boolean runOnce();
  
  Payload[] payloads();
  
  /**
   * The configuration of the virtual machine's placement policy.
    * 
    * This configuration can be updated to pin a virtual machine to one or more hosts.
    * 
    * NOTE: Virtual machines that are pinned to multiple hosts cannot be live migrated, but in the event of a host
    * failure, any virtual machine configured to be highly available is automatically restarted on one of the other
    * hosts to which the virtual machine is pinned.
    * 
    * For example, to pin a virtual machine to two hosts, you would send a request like the following:
    *          
    * [source]
    * ----
    * PUT /api/vms/123
    * ----
    * 
    * With a request body like this:
    * 
    * [source,xml]
    * ----
    * <vm>
    *  <high_availability>
    *   <enabled>true</enabled>
    *   <priority>1</priority>
    *  </high_availability>
    *  <placement_policy>
    *   <hosts>
    *    <host>
    *     <name>Host1</name>
    *    </host>
    *    <host>
    *     <name>Host2</name>
    *    </host>
    *   </hosts>
    *  <affinity>pinned</affinity>
    *  </placement_policy>
    * </vm>
    * ----
   *
   * @author Phillip Bailey <phbailey@redhat.com>
   * @date 14 Sep 2016
   * @status added
   */
  VmPlacementPolicy placementPolicy();
  
  String fqdn();
  
  Boolean useLatestTemplateVersion();
  
  Boolean nextRunConfigurationExists();
  
  NumaTuneMode numaTuneMode();
  
  TimeZone guestTimeZone();
  
  GuestOperatingSystem guestOperatingSystem();
  
  @Link Host host();
  
  @Link Template template();
  
  /**
   * References to the original template the virtual machine was created from.
    * 
    * If the virtual machine is cloned from a template or another virtual machine,
    * the `template` links to the Blank template and the `original_template`
    * is used to track history.
    * 
    * Otherwise the `template` and `original_template` are the same.
   *
   * @author Marek Libra <mlibra@redhat.com>
   * @date 8 Jul 2016
   * @status added
   */
  @Link Template originalTemplate();
  
  @Link InstanceType instanceType();
  
  /**
   * Link to the the list of network interface devices on the virtual machine.
   *
   * @author Martin Mucha <mmucha@redhat.com>
   * @date 14 Sep 2016
   * @status added
   */
  @Link Nic[] nics();
  
  @Link Snapshot[] snapshots();
  
  @Link VmPool vmPool();
  
  @Link Cdrom[] cdroms();
  
  @Link Floppy[] floppies();
  
  @Link ReportedDevice[] reportedDevices();
  
  @Link Watchdog[] watchdogs();
  
  @Link Permission[] permissions();
  
  @Link ExternalHostProvider externalHostProvider();
  
  @Link AffinityLabel[] affinityLabels();
  
  @Link Application[] applications();
  
  @Link GraphicsConsole[] graphicsConsoles();
  
  @Link HostDevice[] hostDevices();
  
  @Link KatelloErratum[] katelloErrata();
  
  @Link NumaNode[] numaNodes();
  
  @Link Session[] sessions();
  
  @Link Statistic[] statistics();
  
  @Link Tag[] tags();
  
  /**
   * References to the disks attached to the virtual machine.
   */
  @Link DiskAttachment[] diskAttachments();
}
