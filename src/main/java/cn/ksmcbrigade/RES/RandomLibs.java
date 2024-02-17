package cn.ksmcbrigade.RES;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Random;

public class RandomLibs {
    public static final String strings = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,0,1,2,3,4,5,6,7,8,9,`,~,!,@,#,$,%,^,&,*,(,),-,=,_,+,[,],\\,{,},|,;,',:,<,>,/,?,dh,.";
    public static final String colors = "§1,§2,§3,§4,§5,§6,§7,§8,§9,§0,§a,§b,§c,§d,§e,§f,§g,§h,§i,§j,§m,§n,§p,§q,§s,§t,§u,§k,§l,§o,§r";
    public static final Item[] items = (Item[]) get("item");
    public static final Block[] blocks = (Block[]) get("block");
    public static final Enchantment[] enchantments = (Enchantment[]) get("enchant");
    public static final EntityType[] entityTypes = (EntityType[]) get("entity");
    public static Potion[] potions = (Potion[]) get("potion");
    public static Potion[] potions2 = (Potion[]) get("potion2");
    public static final MobEffect[] effects = (MobEffect[]) get("effect");

    public static final Item[] ores = new Item[]{Items.COAL_ORE,Items.DEEPSLATE_COAL_ORE,Items.IRON_ORE,Items.DEEPSLATE_IRON_ORE,Items.GOLD_ORE,Items.DEEPSLATE_GOLD_ORE,Items.REDSTONE_ORE,Items.DEEPSLATE_REDSTONE_ORE,Items.LAPIS_ORE,Items.DEEPSLATE_LAPIS_ORE,Items.EMERALD_ORE,Items.DEEPSLATE_EMERALD_ORE,Items.DIAMOND_ORE,Items.DEEPSLATE_DIAMOND_ORE,Items.NETHER_QUARTZ_ORE,Items.NETHER_GOLD_ORE,Items.COPPER_ORE,Items.DEEPSLATE_COPPER_ORE,Items.ANCIENT_DEBRIS,Items.COAL_BLOCK,Items.IRON_BLOCK,Items.COPPER_BLOCK,Items.RAW_COPPER_BLOCK,Items.RAW_COPPER,Items.RAW_GOLD_BLOCK,Items.RAW_IRON_BLOCK,Items.RAW_GOLD,Items.RAW_IRON,Items.GOLD_BLOCK,Items.EMERALD_BLOCK,Items.LAPIS_BLOCK,Items.DIAMOND_BLOCK,Items.NETHERITE_BLOCK};
    public static final Block[] ores2 = new Block[]{Blocks.COAL_ORE,Blocks.DEEPSLATE_COAL_ORE,Blocks.IRON_ORE,Blocks.DEEPSLATE_IRON_ORE,Blocks.GOLD_ORE,Blocks.DEEPSLATE_GOLD_ORE,Blocks.REDSTONE_ORE,Blocks.DEEPSLATE_REDSTONE_ORE,Blocks.LAPIS_ORE,Blocks.DEEPSLATE_LAPIS_ORE,Blocks.EMERALD_ORE,Blocks.DEEPSLATE_EMERALD_ORE,Blocks.DIAMOND_ORE,Blocks.DEEPSLATE_DIAMOND_ORE,Blocks.NETHER_QUARTZ_ORE,Blocks.NETHER_GOLD_ORE,Blocks.COPPER_ORE,Blocks.DEEPSLATE_COPPER_ORE,Blocks.ANCIENT_DEBRIS,Blocks.COAL_BLOCK,Blocks.IRON_BLOCK,Blocks.COPPER_BLOCK,Blocks.RAW_COPPER_BLOCK,Blocks.RAW_GOLD_BLOCK,Blocks.RAW_IRON_BLOCK,Blocks.GOLD_BLOCK,Blocks.EMERALD_BLOCK,Blocks.LAPIS_BLOCK,Blocks.DIAMOND_BLOCK,Blocks.NETHERITE_BLOCK};

    public RandomLibs(){
    }

    public static Object[] get(String type){
        if(type.equalsIgnoreCase("item")){
            ArrayList<Item> itemArrayList = new ArrayList<>();
            Class<?> itemsClass = Items.class;
            for(Field field:itemsClass.getFields()){
                if(Modifier.isStatic(field.getModifiers())){
                    try {
                        itemArrayList.add((Item) field.get(null));
                    } catch (IllegalAccessException e) {
                        System.out.println("Failed in get item:"+field.getName()+"\n"+getExceptionText(e));
                        return null;
                    }
                }
            }
            return itemArrayList.toArray(new Item[itemArrayList.size()]);
        }
        else if(type.equalsIgnoreCase("block")){
            ArrayList<Block> itemArrayList = new ArrayList<>();
            Class<?> itemsClass = Blocks.class;
            for(Field field:itemsClass.getFields()){
                if(Modifier.isStatic(field.getModifiers())){
                    try {
                        itemArrayList.add((Block) field.get(null));
                    } catch (IllegalAccessException e) {
                        System.out.println("Failed in get block:"+field.getName()+"\n"+getExceptionText(e));
                        return null;
                    }
                }
            }
            return itemArrayList.toArray(new Block[itemArrayList.size()]);
        }
        else if(type.equalsIgnoreCase("enchant")){
            ArrayList<Enchantment> itemArrayList = new ArrayList<>();
            Class<?> itemsClass = Enchantments.class;
            for(Field field:itemsClass.getFields()){
                if(Modifier.isStatic(field.getModifiers())){
                    try {
                        itemArrayList.add((Enchantment) field.get(null));
                    } catch (IllegalAccessException e) {
                        System.out.println("Failed in get enchantment:"+field.getName()+"\n"+getExceptionText(e));
                        return null;
                    }
                }
            }
            return itemArrayList.toArray(new Enchantment[itemArrayList.size()]);
        }
        else if(type.equalsIgnoreCase("entity")){
            ArrayList<EntityType> itemArrayList = new ArrayList<>();
            Class<?> itemsClass = EntityType.class;
            for(Field field:itemsClass.getFields()){
                if(Modifier.isStatic(field.getModifiers()) && field.getType().equals(EntityType.class)){
                    try {
                        itemArrayList.add((EntityType) field.get(null));
                    } catch (IllegalAccessException e) {
                        System.out.println("Failed in get entity:"+field.getName()+"\n"+getExceptionText(e));
                        return null;
                    }
                }
            }
            return itemArrayList.toArray(new EntityType[itemArrayList.size()]);
        }
        else if(type.equalsIgnoreCase("potion")){
            ArrayList<Potion> itemArrayList = new ArrayList<>();
            Class<?> itemsClass = MobEffects.class;
            for(Field field:itemsClass.getFields()){
                if(Modifier.isStatic(field.getModifiers())){
                    try {
                        itemArrayList.add(new Potion(new MobEffectInstance((MobEffect) field.get(null),new Random().nextInt(1200,12001),new Random().nextInt(-100,127))));
                    } catch (IllegalAccessException e) {
                        System.out.println("Failed in get potion:"+field.getName()+"\n"+getExceptionText(e));
                        return null;
                    }
                }
            }
            return itemArrayList.toArray(new Potion[itemArrayList.size()]);
        }
        else if(type.equalsIgnoreCase("potion2")){
            ArrayList<Potion> itemArrayList = new ArrayList<>();
            Class<?> itemsClass = Potions.class;
            for(Field field:itemsClass.getFields()){
                if(Modifier.isStatic(field.getModifiers())){
                    try {
                        itemArrayList.add((Potion) field.get(null));
                    } catch (IllegalAccessException e) {
                        System.out.println("Failed in get potion:"+field.getName()+"\n"+getExceptionText(e));
                        return null;
                    }
                }
            }
            return itemArrayList.toArray(new Potion[itemArrayList.size()]);
        }
        else if(type.equalsIgnoreCase("effect")){
            ArrayList<MobEffect> itemArrayList = new ArrayList<>();
            Class<?> itemsClass = MobEffects.class;
            for(Field field:itemsClass.getFields()){
                if(Modifier.isStatic(field.getModifiers()) && field.getType().equals(MobEffect.class)){
                    try {
                        itemArrayList.add((MobEffect) field.get(null));
                    } catch (IllegalAccessException e) {
                        System.out.println("Failed in get effect:"+field.getName()+"\n"+getExceptionText(e));
                        return null;
                    }
                }
            }
            return itemArrayList.toArray(new MobEffect[itemArrayList.size()]);
        }
        else{
            return null;
        }
    }

    public static long getRandomNumber(long max){
        return Math.round(Math.random()*max);
    }

    public static String getRandomString(int length){
        String[] strs = strings.split(",");
        String randomStrs = "";
        for(int i=0;i<length;i++){
            String randomStr = strs[(int) Math.floor(Math.random()*(strs.length-1))].replace("dh",",");
            if(randomStrs.equalsIgnoreCase("")){
                randomStrs = randomStr;
            }
            else{
                randomStrs = randomStrs + randomStr;
            }
        }
        return randomStrs;
    }

    public static Item getRandomItem(){
        if (items != null) {
            int r = (int) Math.floor(Math.random()* (items.length-1));
            return items[r];
        }
        else{
            return null;
        }
    }

    public static Block getRandomBlock(){
        if (blocks != null) {
            return blocks[(int) Math.floor(Math.random()* (blocks.length-1))];
        }
        else{
            return null;
        }
    }

    public static Enchantment getRandomEnchant(){
        if (enchantments != null) {
            return enchantments[(int) Math.floor(Math.random()* (enchantments.length-1))];
        }
        else{
            return null;
        }
    }

    public static EntityType getRandomEntity(){
        if (entityTypes != null) {
            return entityTypes[(int) Math.floor(Math.random()* (entityTypes.length-1))];
        }
        else{
            return null;
        }
    }

    public static Potion getRandomPotion(){
        potions = (Potion[]) get("potion");
        if (potions != null) {
            int r = (int) Math.floor(Math.random()* (potions.length-1));
            return potions[r];
        }
        else{
            return null;
        }
    }

    public static Potion getRandomPotion2(){
        potions2 = (Potion[]) get("potion2");
        if (potions2 != null) {
            int r = (int) Math.floor(Math.random()* (potions2.length-1));
            return potions2[r];
        }
        else{
            return null;
        }
    }

    public static Item getRandomOreBlockItem(){
        //Item[] ores = new Item[]{Items.COAL_ORE,Items.DEEPSLATE_COAL_ORE,Items.IRON_ORE,Items.DEEPSLATE_IRON_ORE,Items.GOLD_ORE,Items.DEEPSLATE_GOLD_ORE,Items.REDSTONE_ORE,Items.DEEPSLATE_REDSTONE_ORE,Items.LAPIS_ORE,Items.DEEPSLATE_LAPIS_ORE,Items.EMERALD_ORE,Items.DEEPSLATE_EMERALD_ORE,Items.DIAMOND_ORE,Items.DEEPSLATE_DIAMOND_ORE,Items.NETHER_QUARTZ_ORE,Items.NETHER_GOLD_ORE,Items.COPPER_ORE,Items.DEEPSLATE_COPPER_ORE,Items.ANCIENT_DEBRIS,Items.COAL_BLOCK,Items.IRON_BLOCK,Items.COPPER_BLOCK,Items.RAW_COPPER_BLOCK,Items.RAW_COPPER,Items.RAW_GOLD_BLOCK,Items.RAW_IRON_BLOCK,Items.RAW_GOLD,Items.RAW_IRON,Items.GOLD_BLOCK,Items.EMERALD_BLOCK,Items.LAPIS_BLOCK,Items.DIAMOND_BLOCK,Items.NETHERITE_BLOCK};
        int r = (int) Math.floor(Math.random()* (ores.length-1));
        return ores[r];
    }

    public static Block getRandomOreBlock(){
        //Block[] ores = new Block[]{Blocks.COAL_ORE,Blocks.DEEPSLATE_COAL_ORE,Blocks.IRON_ORE,Blocks.DEEPSLATE_IRON_ORE,Blocks.GOLD_ORE,Blocks.DEEPSLATE_GOLD_ORE,Blocks.REDSTONE_ORE,Blocks.DEEPSLATE_REDSTONE_ORE,Blocks.LAPIS_ORE,Blocks.DEEPSLATE_LAPIS_ORE,Blocks.EMERALD_ORE,Blocks.DEEPSLATE_EMERALD_ORE,Blocks.DIAMOND_ORE,Blocks.DEEPSLATE_DIAMOND_ORE,Blocks.NETHER_QUARTZ_ORE,Blocks.NETHER_GOLD_ORE,Blocks.COPPER_ORE,Blocks.DEEPSLATE_COPPER_ORE,Blocks.ANCIENT_DEBRIS,Blocks.COAL_BLOCK,Blocks.IRON_BLOCK,Blocks.COPPER_BLOCK,Blocks.RAW_COPPER_BLOCK,Blocks.RAW_GOLD_BLOCK,Blocks.RAW_IRON_BLOCK,Blocks.GOLD_BLOCK,Blocks.EMERALD_BLOCK,Blocks.LAPIS_BLOCK,Blocks.DIAMOND_BLOCK,Blocks.NETHERITE_BLOCK};
        int r = (int) Math.floor(Math.random()* (ores2.length-1));
        return ores2[r];
    }

    public static String getRandomColor(){
        return colors.split(",")[(int) Math.floor(Math.random()*(colors.split(",").length-1))];
    }

    public static String getExceptionText(Exception e){
        String text = e.toString();
        for(StackTraceElement ste:e.getStackTrace()){
            text=text+"\nat "+ste;
        }
        return text;
    }
}
