package groppedev.freemarker;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class Test {

    public static void main(String[] args) throws Exception {

    	
        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        // Recommended settings for new projects:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        cfg.setTemplateLoader(new ClassTemplateLoader(Test.class, "/groppedev/freemarker/templates"));

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */

        /* Create a data-model */
        @SuppressWarnings("rawtypes")
		Map root = new HashMap();
        root.put("user", "groppedev");
        root.put("tomcats", new String[] {"tomcat_a","tomcat_b"});

        
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("test.ftlh");

        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
    }
}