import SnmpAPI.*;
import SnmpPDU.*;



public class snmpGet {
	public static void main (String args[]) {
		
		
		String remoteHost = args[0]; //address of the remote host of where the agent is running
		String OID = args[1]; //the identifier of the object
		
		
		//instantiating an SNMP API and creating an SNMP session with remote host
		SnmpAPI api = new SnmpAPI();
		api.start();
		
		SnmpSession session = new SnmpSession(api);
		session.setPeername(remoteHost);
		session.open();
		
		//building request for send/receive PDU
		SnmpPDU pdu = new SnmpPDU();
		pdu.setCommand(api.GET_REQ_MSG); //setting the PDU type
		SnmpOID oid = new SnmpOID(OID);
		pdu.addNull(oid);
		pdu = session.syncSend(pdu);
		
		//extracting the information from received PDU
		System.out.println(pdu.printVarBinds()); //packet received
		SnmpVarBind snmp = new SnmpVarBind(0);
		System.out.println(snmpVar.getObjectID().toString());
		System.out.println(snmpVar.getVariable().toValue()); //packet received
		
		
		
		
	}
}
