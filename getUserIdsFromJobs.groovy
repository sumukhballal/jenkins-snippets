import jenkins.*;
import hudson.*;
import hudson.model.*;

jenkins = Hudson.instance

for(item in jenkins.items)
{
  String name = item.name;
  /* Put any Job Name */
  if(name.equals("test"))
  {
    for(build in item.builds)
    {
      println("---------")
	/* See which user triggerred this build */
      println("\t ${build.getCauses()[0].getUserId()}");
	/* Get Build Parameters for this build */
      def parameters = build.getAction(ParametersAction)?.parameters
      parameters.each {
        println "Type: ${it.class} Name: ${it.name}, Value: ${it.dump()}" 
	}	
    }
  }
}
