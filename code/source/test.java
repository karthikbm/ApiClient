

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.lang.ns.NSName;
import com.softwareag.util.IDataMap;
// --- <<IS-END-IMPORTS>> ---

public final class test

{
	// ---( internal utility methods )---

	final static test _instance = new test();

	static test _newInstance() { return new test(); }

	static test _cast(Object o) { return (test)o; }

	// ---( server methods )---




	public static final void TestApi (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(TestApi)>> ---
		// @sigtype java 3.5
		// [i] field:0:required agentId
		// [i] field:0:optional agentGroup
		// [i] field:0:required assetType
		// [i] field:0:required name
		// [i] field:0:required packageName
		// [i] field:0:required connectionEnabled
		// [i] field:0:required connectionAlias
		// [i] field:0:required pwdVal
		// [o] field:0:required output
		String AGENT_ID = "agentId";
		String AGENT_GROUP = "agentGroup";
		String ASSET_TYPE = "assetType";
		String ASSET_DATA = "assetData";
		String NAME = "name";
		String PACKAGE_NAME = "packageName";
		String CONNECTION_ENABLED = "connectionEnabled";
		String CONNECTION_ALIAS = "connectionAlias";
		String CONNECTION_CONFIGURATION = "connectionconfiguration";
		String PWDKEY = "cr..password";
		String pwdVal = "pwdVal";
		
		String agentID = ValuesEmulator.getString(pipeline, AGENT_ID);
		String agentGroup = ValuesEmulator.getString(pipeline, AGENT_GROUP);
		String assetType = ValuesEmulator.getString(pipeline, ASSET_TYPE);
		
		String name = ValuesEmulator.getString(pipeline, NAME);
		String pkgName = ValuesEmulator.getString(pipeline, PACKAGE_NAME);
		String connEnabled = ValuesEmulator.getString(pipeline, CONNECTION_ENABLED);
		String connAlias = ValuesEmulator.getString(pipeline, CONNECTION_ALIAS);
		String pwdValStr = ValuesEmulator.getString(pipeline, pwdVal);
		
		//		IDataMap connConfigMap = new IDataMap();
		//		connConfigMap.put(PWDKEY, pwdValStr);
		
		IDataMap assetDataMap = new IDataMap();
		assetDataMap.put(NAME, name);
		assetDataMap.put(PACKAGE_NAME, pkgName);
		assetDataMap.put(CONNECTION_ENABLED, connEnabled);
		assetDataMap.put(CONNECTION_ALIAS, connAlias);
		assetDataMap.put(PWDKEY, pwdValStr);
		
		IDataMap inputMap = new IDataMap();
		
		inputMap.put(AGENT_ID, agentID);
		inputMap.put(AGENT_GROUP, agentGroup);
		inputMap.put(ASSET_TYPE, assetType);
		
		inputMap.put(ASSET_DATA, assetDataMap.getIData());
		
		NSName serviceNS = NSName.create("wm.client.scaffolding.assets:updateAssetInManifest");
		try {
		String msg = "Invoking wm.client.scaffolding.assets:updateAssetInManifest with input new2: " + inputMap.getIData();
		System.out.println(msg);
		
		IDataMap logInputMap = new IDataMap();
		logInputMap.put("connectorID", "DEMO");
		logInputMap.put("message", msg);
		
		Service.doInvoke(NSName.create("wm.cloudstreams.service.util.runtime:log"), logInputMap.getIData());
		
		IData result = Service.doInvoke(serviceNS, inputMap.getIData());
		System.out.println(
		"Invocation of wm.client.scaffolding.assets:updateAssetInManifest successful response: " + result);
		ValuesEmulator.put(pipeline, "output", result);
		} catch (Exception e) {
		e.printStackTrace();
		ValuesEmulator.put(pipeline, "error", "ERROR OCCURRED " + e.getLocalizedMessage());
		}
		// --- <<IS-END>> ---

                
	}
}

