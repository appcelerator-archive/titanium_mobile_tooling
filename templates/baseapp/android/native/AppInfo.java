package ${config['appid']};

import org.appcelerator.titanium.ITiAppInfo;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiProperties;
import org.appcelerator.kroll.common.Log;

/* GENERATED CODE
 * Warning - this class was generated from your application's tiapp.xml
 * Any changes you make here will be overwritten
 */
public final class ${config['classname']}AppInfo implements ITiAppInfo
{
	private static final String LCAT = "AppInfo";
	
	public ${config['classname']}AppInfo(TiApplication app) {
		%if len(app_properties.keys()) > 0:
		TiProperties properties = app.getSystemProperties();
		TiProperties appProperties = app.getAppProperties();
			%for property in app_properties.keys():
				%try:
					<%
					value = app_properties[property]['value']
					type = app_properties[property]['type']
					if type == 'string': javaValue = '"%s"' % value
					elif type == 'bool': javaValue = str(value in ['true', 'True', 'TRUE', 'yes', 'Yes', 'YES', 'y', 't', '1']).lower()
					elif type == 'int': javaValue = int(value)
					elif type == 'double': javaValue = float(value)
					setter = 'set%s' % type[0:1].upper() + type[1:]
					%>
					properties.${setter}("${property}", ${javaValue});
					appProperties.${setter}("${property}", ${javaValue});
				%except:
		Log.w(LCAT, "Couldn't convert application property '${property}', with value '${value}' to ${type}, skipping.");
				%endtry
			%endfor
		%endif
	}
	
	public String getId() {
		return "${app_info['id']}";
	}
	
	public String getName() {
		return "${app_info['name']}";
	}
	
	public String getVersion() {
		return "${app_info['version']}";
	}
	
	public String getPublisher() {
		return "${app_info['publisher']}";
	}
	
	public String getUrl() {
		return "${app_info['url']}";
	}
	
	public String getCopyright() {
		return "${app_info['copyright']}";
	}
	
	public String getDescription() {
		return "${app_info['description']}";
	}
	
	public String getIcon() {
		return "${app_info['icon']}";
	}
	
	public boolean isAnalyticsEnabled() {
		return ${app_info['analytics']};
	}
	
	public String getGUID() {
		return "${app_info['guid']}";
	}
	
	public boolean isFullscreen() {
		return ${app_info['fullscreen']};
	}
	
	public boolean isNavBarHidden() {
		return ${app_info['navbar-hidden']};
	}
}
