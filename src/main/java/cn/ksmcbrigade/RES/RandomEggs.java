package cn.ksmcbrigade.RES;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Mod("res")
public class RandomEggs {

    public static final Logger LOGGER = LogManager.getLogger();
    public static int Max = 32;

    public RandomEggs() throws IOException {
        MinecraftForge.EVENT_BUS.register(this);
        File file = new File("config/res-config.json");
        if(!file.exists()){
            JsonObject json = new JsonObject();
            json.addProperty("MaxRand",32);
            Files.write(file.toPath(), json.toString().getBytes());
        }
        Max = JsonParser.parseString(Files.readString(file.toPath())).getAsJsonObject().get("MaxRand").getAsInt();
        LOGGER.info("RandomEggs loaded.");
    }
}
