package tending;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.net.Administration.*;
import mindustry.world.blocks.storage.*;
import org.python.util.PythonInterpreter;

public class PyForMindustry extends Plugin {
	@Override
    public void init(){
    	Log.info("Hello, java!");
        PythonInterpreter pyInterp = new PythonInterpreter();
    	try {
	      pyInterp.exec("print('Jython succesfully loaded!')");
	    }
        catch (Exception e){
            Log.info("Cannot load jython!");
            Log.info(e);
        }
    }
    @Override
    public void registerServerCommands(CommandHandler handler){
    	handler.register("sus", "boulder", args -> {
    		Log.info("Hello, world!");	
    	});
    	handler.register("py", "<code...>", "jython", args -> {
            String code = String.join(" ", args);
            try (PythonInterpreter pyInterp = new PythonInterpreter();) {
                pyInterp.exec(code);
            } catch (Exception e) {
                Log.info("Something went wrong.");
                Log.info(e);
            }
    	});
    }
}