package cz.wejn.awesome;

import com.wowza.wms.module.*;
import com.wowza.wms.application.*;
import com.wowza.wms.logging.*;

public class Module extends ModuleBase
{
	private String name = null;

	public void onAppStart(IApplicationInstance ai)
	{
		for (Object mn: ai.getModuleList().getModuleNames()) {
			if (ai.getModuleList().getModuleItem((String) mn).
					getInstance().equals(this)) {
				// getLogger().info("Found my name: " + (String) mn);
				this.name = (String) mn;
			}
		}

		if (this.name == null) {
			getLogger().warn("awesome.Module[" + ai.getContextStr() + 
				"]: Couldn't quite figure out my own name. :-(");
		} else {
			WMSProperties props = ai.getProperties();
			String prop = props.getPropertyStr(this.name +
				"ImportantProperty");
			if (prop == null) {
				getLogger().warn("awesome.Module<" + this.name + ">[" +
					ai.getContextStr() + "]: No property for me. :-(");
			} else {
				getLogger().info("awesome.Module<" + this.name + ">[" +
					ai.getContextStr() + "]: Got it: " + prop);
			}
		}
	}
}
