package cn.ksmcbrigade.RES.mixin;

import cn.ksmcbrigade.RES.RandomEggs;
import cn.ksmcbrigade.RES.RandomLibs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;

@Mixin(ThrownEgg.class)
public abstract class EggEntityMixin extends ThrowableItemProjectile {

    public EggEntityMixin(EntityType<? extends ThrowableItemProjectile> p_37442_, Level p_37443_) {
        super(p_37442_, p_37443_);
    }

    /**
     * @author KSmc_brigade
     * @reason reWrite onHit
     */
    @Overwrite
    protected void onHit(@NotNull HitResult p_37488_) {
        super.onHit(p_37488_);
        if (!this.level.isClientSide) {
            Vec3 pos = p_37488_.getLocation();
            Random rand = new Random();
            int ran = rand.nextInt(0,8); //max=7
            RandomEggs.LOGGER.info("Random number: "+ran);
            if(ran==0){ //item
                if(rand.nextBoolean()){ //enchantment?
                    if(rand.nextBoolean()){
                        ItemStack itemStack = Objects.requireNonNull(RandomLibs.getRandomItem()).getDefaultInstance();
                        itemStack.enchant(Objects.requireNonNull(RandomLibs.getRandomEnchant()),rand.nextInt(255));
                        for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                            ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                            this.level.addFreshEntity(item);
                        }
                    }
                    else{
                        for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                            ItemStack itemStack = Objects.requireNonNull(RandomLibs.getRandomItem()).getDefaultInstance();
                            itemStack.enchant(Objects.requireNonNull(RandomLibs.getRandomEnchant()),rand.nextInt(255));
                            ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                            this.level.addFreshEntity(item);
                        }
                    }
                }
                else{
                    if(rand.nextBoolean()){
                        ItemStack itemStack = Objects.requireNonNull(RandomLibs.getRandomItem()).getDefaultInstance();
                        for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                            ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                            this.level.addFreshEntity(item);
                        }
                    }
                    else{
                        for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                            ItemStack itemStack = Objects.requireNonNull(RandomLibs.getRandomItem()).getDefaultInstance();
                            ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                            this.level.addFreshEntity(item);
                        }
                    }
                }
            }
            else if(ran==1){ //blocks
                if(rand.nextBoolean()){
                    BlockState block = Objects.requireNonNull(RandomLibs.getRandomBlock()).defaultBlockState();
                    for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                        BlockPos blockPos = new BlockPos(pos.x,pos.y+i,pos.z);
                        this.level.setBlockAndUpdate(blockPos,block);
                    }
                }
                else{
                    for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                        BlockState block = Objects.requireNonNull(RandomLibs.getRandomBlock()).defaultBlockState();
                        BlockPos blockPos = new BlockPos(pos.x,pos.y+i,pos.z);
                        this.level.setBlockAndUpdate(blockPos,block);
                    }
                }
            }
            else if(ran==2){ //entities
                if(rand.nextBoolean()){
                    EntityType type = Objects.requireNonNull(RandomLibs.getRandomEntity());
                        Entity entity = type.create(this.level);
                    if (entity != null) {
                        entity.setPos(pos);
                    }
                    for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else{
                    for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                        EntityType type = Objects.requireNonNull(RandomLibs.getRandomEntity());
                            Entity entity = type.create(this.level);
                        if (entity != null) {
                            entity.setPos(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
            }
            else if(ran==3){ //enchantments
                if(rand.nextBoolean()){
                    ItemStack itemStack = Items.ENCHANTED_BOOK.getDefaultInstance();
                    itemStack.enchant(Objects.requireNonNull(RandomLibs.getRandomEnchant()),rand.nextInt(-1,5));
                    for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                        ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                        this.level.addFreshEntity(item);
                    }
                }
                else{
                    for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                        ItemStack itemStack = Items.ENCHANTED_BOOK.getDefaultInstance();
                        itemStack.enchant(Objects.requireNonNull(RandomLibs.getRandomEnchant()),rand.nextInt(-1,5));
                        ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                        this.level.addFreshEntity(item);
                    }
                }
            }
            else if(ran==4){ //explode
                if(rand.nextBoolean()){
                    int ran2 = rand.nextInt(1,4);
                    if(ran2==1){
                        this.level.explode(null,pos.x,pos.y,pos.z,rand.nextInt(127), Explosion.BlockInteraction.DESTROY);
                    }
                    else if(ran2==2){
                        this.level.explode(null,pos.x,pos.y,pos.z,rand.nextInt(127), Explosion.BlockInteraction.BREAK);
                    }
                    else{
                        this.level.explode(null,pos.x,pos.y,pos.z,rand.nextInt(127), Explosion.BlockInteraction.NONE);
                    }
                }
                else {
                    Entity entity = EntityType.CREEPER.create(this.level);
                    if (entity != null) {
                        entity.moveTo(pos);
                    }
                    if (entity != null) {
                        this.level.addFreshEntity(entity);
                    }
                }
            }
            else if(ran==5){  //potion
                    if(rand.nextBoolean()){
                        ItemStack itemStack = Items.POTION.getDefaultInstance();
                        PotionUtils.setPotion(itemStack, Objects.requireNonNull(RandomLibs.getRandomPotion2()));
                        for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                            ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                            this.level.addFreshEntity(item);
                        }
                    }
                    else{
                        for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                            ItemStack itemStack = Items.POTION.getDefaultInstance();
                            PotionUtils.setPotion(itemStack, Objects.requireNonNull(RandomLibs.getRandomPotion2()));
                            ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                            this.level.addFreshEntity(item);
                        }
                    }
            }
            else if(ran==6){
                int ran3 = rand.nextInt(0,43); //max=41
                RandomEggs.LOGGER.info("Random number2: "+ran3);
                if(ran3==0){
                    if(rand.nextBoolean()){ //item?
                        if(rand.nextBoolean()){
                            ItemStack itemStack = RandomLibs.getRandomOreBlockItem().getDefaultInstance();
                            for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                                ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                                this.level.addFreshEntity(item);
                            }
                        }
                        else{
                            for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                                ItemStack itemStack = RandomLibs.getRandomOreBlockItem().getDefaultInstance();
                                ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                                this.level.addFreshEntity(item);
                            }
                        }
                    }
                    else{
                        if(rand.nextBoolean()){
                            BlockState block = Objects.requireNonNull(RandomLibs.getRandomBlock()).defaultBlockState();
                            for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                                BlockPos blockPos = new BlockPos(pos.x,pos.y+i,pos.z);
                                this.level.setBlockAndUpdate(blockPos,block);
                            }
                        }
                        else{
                            for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                                BlockState block = Objects.requireNonNull(RandomLibs.getRandomBlock()).defaultBlockState();
                                BlockPos blockPos = new BlockPos(pos.x,pos.y+i,pos.z);
                                this.level.setBlockAndUpdate(blockPos,block);
                            }
                        }
                    }
                } else if(ran3==1){
                    ItemStack itemStack = Items.POTION.getDefaultInstance();
                    RandomLibs.potions = (Potion[]) RandomLibs.get("potion");
                    Collection<MobEffectInstance> effects = new ArrayList<>();
                    if (RandomLibs.potions != null) {
                        for(Potion potion:RandomLibs.potions){
                            effects.add(potion.getEffects().get(0));
                        }
                    }
                    PotionUtils.setCustomEffects(itemStack, effects);
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==2){
                    ItemStack itemStack = Items.POTION.getDefaultInstance();
                    Collection<MobEffectInstance> effects = new ArrayList<>();
                    if (RandomLibs.effects != null) {
                        for(MobEffect effect:RandomLibs.effects){
                            effects.add(new MobEffectInstance(effect,rand.nextInt(1200,12001),100));
                        }
                    }
                    PotionUtils.setCustomEffects(itemStack, effects);
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==3){
                    ItemStack itemStack = Items.POTION.getDefaultInstance();
                    Collection<MobEffectInstance> effects = new ArrayList<>();
                    if (RandomLibs.effects != null) {
                        for(MobEffect effect:RandomLibs.effects){
                            effects.add(new MobEffectInstance(effect,rand.nextInt(1200,12001),-100));
                        }
                    }
                    PotionUtils.setCustomEffects(itemStack, effects);
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==4){
                    ItemStack itemStack = Items.POTION.getDefaultInstance();
                    Collection<MobEffectInstance> effects = new ArrayList<>();
                    if (RandomLibs.effects != null) {
                        for(MobEffect effect:RandomLibs.effects){
                            effects.add(new MobEffectInstance(effect,rand.nextInt(1200,12001),127));
                        }
                    }
                    PotionUtils.setCustomEffects(itemStack, effects);
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==5){
                    ItemStack itemStack = Items.POTION.getDefaultInstance();
                    Collection<MobEffectInstance> effects = new ArrayList<>();
                    if (RandomLibs.effects != null) {
                        for(MobEffect effect:RandomLibs.effects){
                            if(effect.getCategory().equals(MobEffectCategory.HARMFUL)){
                                effects.add(new MobEffectInstance(effect,rand.nextInt(1200,12001),127));
                            }
                        }
                    }
                    PotionUtils.setCustomEffects(itemStack, effects);
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==6){
                    ItemStack itemStack = Items.POTION.getDefaultInstance();
                    Collection<MobEffectInstance> effects = new ArrayList<>();
                    if (RandomLibs.effects != null) {
                        for(MobEffect effect:RandomLibs.effects){
                            if(effect.getCategory().equals(MobEffectCategory.BENEFICIAL)){
                                effects.add(new MobEffectInstance(effect,rand.nextInt(1200,12001),127));
                            }
                        }
                    }
                    PotionUtils.setCustomEffects(itemStack, effects);
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==7){
                    ItemStack itemStack = Items.POTION.getDefaultInstance();
                    Collection<MobEffectInstance> effects = new ArrayList<>();
                    if (RandomLibs.effects != null) {
                        for(MobEffect effect:RandomLibs.effects){
                            if(effect.getCategory().equals(MobEffectCategory.NEUTRAL)){
                                effects.add(new MobEffectInstance(effect,rand.nextInt(1200,12001),127));
                            }
                        }
                    }
                    PotionUtils.setCustomEffects(itemStack, effects);
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==8){
                    for(int i=0;i<100;i++){
                            Entity entity = EntityType.TNT.create(this.level);
                        if (entity != null) {
                            entity.moveTo(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==9){
                    for(int i=0;i<100;i++){
                        Entity entity = Objects.requireNonNull(RandomLibs.getRandomEntity()).create(this.level);
                        if (entity != null) {
                            entity.moveTo(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==10){
                    for(int i=0;i<100;i++){
                        Entity entity = Objects.requireNonNull(RandomLibs.getRandomEntity()).create(this.level);
                        if (entity != null && entity.getType().getCategory().equals(MobCategory.MONSTER)) {
                            entity.moveTo(pos);
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==11){
                    for(int i=0;i<100;i++){
                        Entity entity = Objects.requireNonNull(RandomLibs.getRandomEntity()).create(this.level);
                        if (entity != null && entity.getType().getCategory().equals(MobCategory.AXOLOTLS)) {
                            entity.moveTo(pos);
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==12){
                    for(int i=0;i<100;i++){
                        Entity entity = EntityType.EXPERIENCE_BOTTLE.create(this.level);
                        if (entity != null) {
                            entity.moveTo(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==13){
                    for(int i=0;i<100;i++){
                        Entity entity = EntityType.EXPERIENCE_ORB.create(this.level);
                        if (entity != null) {
                            entity.moveTo(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==14){
                    for(int i=0;i<100;i++){
                        Entity entity = EntityType.TNT_MINECART.create(this.level);
                        if (entity != null) {
                            entity.moveTo(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==15){
                    for(int i=0;i<10;i++){
                        Entity entity = EntityType.WITHER.create(this.level);
                        if (entity != null) {
                            entity.moveTo(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==16){
                    ItemStack itemStack = Objects.requireNonNull(RandomLibs.getRandomItem()).getDefaultInstance();
                    itemStack.enchant(Objects.requireNonNull(RandomLibs.getRandomEnchant()),126);
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==17){
                    ItemStack itemStack = Objects.requireNonNull(RandomLibs.getRandomItem()).getDefaultInstance();
                    itemStack.enchant(Objects.requireNonNull(RandomLibs.getRandomEnchant()),-126);
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==18){
                    for(int i=0;i<rand.nextInt(1,RandomEggs.Max);i++){
                        ItemStack itemStack = Objects.requireNonNull(RandomLibs.getRandomItem()).getDefaultInstance();
                        itemStack.enchant(Objects.requireNonNull(RandomLibs.getRandomEnchant()),126);
                        ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                        this.level.addFreshEntity(item);
                    }
                }
                else if(ran3==19){
                    for(int i=0;i<rand.nextInt(1,RandomEggs.Max);i++){
                        ItemStack itemStack = Objects.requireNonNull(RandomLibs.getRandomItem()).getDefaultInstance();
                        itemStack.enchant(Objects.requireNonNull(RandomLibs.getRandomEnchant()),-126);
                        ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                        this.level.addFreshEntity(item);
                    }
                }
                else if(ran3==20){
                    for(int i=0;i<24;i++){
                        ItemStack itemStack = Objects.requireNonNull(RandomLibs.getRandomItem()).getDefaultInstance();
                        itemStack.enchant(Objects.requireNonNull(RandomLibs.getRandomEnchant()),126);
                        ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                        this.level.addFreshEntity(item);
                    }
                }
                else if(ran3==21){
                    for(int i=0;i<24;i++){
                        ItemStack itemStack = Objects.requireNonNull(RandomLibs.getRandomItem()).getDefaultInstance();
                        itemStack.enchant(Objects.requireNonNull(RandomLibs.getRandomEnchant()),-126);
                        ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                        this.level.addFreshEntity(item);
                    }
                }
                else if(ran3==22){
                    Item[] items = new Item[]{Items.NETHERITE_SWORD,Items.NETHERITE_AXE,Items.NETHERITE_PICKAXE,Items.NETHERITE_HELMET,Items.NETHERITE_CHESTPLATE,Items.NETHERITE_LEGGINGS,Items.NETHERITE_BOOTS};
                    ItemStack itemStack = items[rand.nextInt((int) Math.floor(Math.random()* (items.length-1)))].getDefaultInstance();
                    if (RandomLibs.enchantments != null) {
                        for(Enchantment enchantment:RandomLibs.enchantments){
                            itemStack.enchant(enchantment,126);
                        }
                    }
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==23){
                    Item[] items = new Item[]{Items.NETHERITE_SWORD,Items.NETHERITE_AXE,Items.NETHERITE_PICKAXE,Items.NETHERITE_HELMET,Items.NETHERITE_CHESTPLATE,Items.NETHERITE_LEGGINGS,Items.NETHERITE_BOOTS};
                    ItemStack itemStack = items[rand.nextInt((int) Math.floor(Math.random()* (items.length-1)))].getDefaultInstance();
                    if (RandomLibs.enchantments != null) {
                        for(Enchantment enchantment:RandomLibs.enchantments){
                            itemStack.enchant(enchantment,126);
                        }
                    }
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==24){
                    Item[] items = new Item[]{Items.NETHERITE_SWORD,Items.NETHERITE_AXE,Items.NETHERITE_PICKAXE,Items.NETHERITE_HELMET,Items.NETHERITE_CHESTPLATE,Items.NETHERITE_LEGGINGS,Items.NETHERITE_BOOTS};
                    for(Item itemt:items){
                        ItemStack itemStack = itemt.getDefaultInstance();
                        if (RandomLibs.enchantments != null) {
                            for(Enchantment enchantment:RandomLibs.enchantments){
                                itemStack.enchant(enchantment,126);
                            }
                        }
                        ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                        this.level.addFreshEntity(item);
                    }
                }
                else if(ran3==25){
                    Item[] items = new Item[]{Items.NETHERITE_SWORD,Items.NETHERITE_AXE,Items.NETHERITE_PICKAXE,Items.NETHERITE_HELMET,Items.NETHERITE_CHESTPLATE,Items.NETHERITE_LEGGINGS,Items.NETHERITE_BOOTS};
                    for(Item itemt:items){
                        ItemStack itemStack = itemt.getDefaultInstance();
                        if (RandomLibs.enchantments != null) {
                            for(Enchantment enchantment:RandomLibs.enchantments){
                                itemStack.enchant(enchantment,0);
                            }
                        }
                        ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                        this.level.addFreshEntity(item);
                    }
                }
                else if(ran3==26){
                    for(int i=0;i<100;i++){
                        Entity entity = EntityType.CREEPER.create(this.level);
                        if (entity != null) {
                            entity.moveTo(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==27){
                    if(rand.nextBoolean()){ //item?
                            for(Item itemu:RandomLibs.ores){
                                ItemStack itemStack = itemu.getDefaultInstance();
                                ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                                for(int i=0;i<rand.nextInt(RandomEggs.Max);i++){
                                    this.level.addFreshEntity(item);
                                }
                            }
                    }
                    else{
                        for(int x=0;x<RandomLibs.ores2.length;x++) {
                            BlockState block = RandomLibs.ores2[x].defaultBlockState();
                            for (int i = 0; i < rand.nextInt(RandomEggs.Max); i++) {
                                BlockPos blockPos = new BlockPos(pos.x, pos.y + i, pos.z);
                                this.level.setBlockAndUpdate(blockPos, block);
                            }
                        }
                    }
                }
                else if(ran3==28){
                    for(int i=0;i<100;i++){
                        Entity entity = EntityType.TROPICAL_FISH.create(this.level);
                        if (entity != null) {
                            entity.moveTo(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==29){
                    for(int i=0;i<rand.nextInt(1,RandomEggs.Max);i++){
                        Entity entity = EntityType.EGG.create(this.level);
                        if (entity != null) {
                            entity.moveTo(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==30){
                    if(rand.nextBoolean()){
                        this.level.addFreshEntity(new ItemEntity(this.level,pos.x,pos.y,pos.z,Items.WATER_BUCKET.getDefaultInstance()));
                    }
                    else {
                        this.level.addFreshEntity(new ItemEntity(this.level,pos.x,pos.y,pos.z,Items.LAVA_BUCKET.getDefaultInstance()));
                    }
                }
                else if(ran3==31){
                    ItemStack itemStack = Items.STONE.getDefaultInstance();
                    itemStack.setCount(16);
                    this.level.addFreshEntity(new ItemEntity(this.level,pos.x,pos.y,pos.z,Items.WATER_BUCKET.getDefaultInstance()));
                    this.level.addFreshEntity(new ItemEntity(this.level,pos.x,pos.y,pos.z,Items.LAVA_BUCKET.getDefaultInstance()));
                    this.level.addFreshEntity(new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack));
                }
                else if(ran3==32){
                    ItemStack itemStack = Items.TOTEM_OF_UNDYING.getDefaultInstance();
                    itemStack.enchant(Enchantments.INFINITY_ARROWS,1);
                    this.level.addFreshEntity(new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack));
                }
                else if(ran3==33){
                    for(Item item:RandomLibs.ores){
                        this.level.addFreshEntity(new ItemEntity(this.level,pos.x,pos.y,pos.z,item.getDefaultInstance()));
                    }
                }
                else if(ran3==34){
                    for(int i=0;i<RandomLibs.ores2.length;i++){
                        BlockPos blockPos = new BlockPos(pos.x,pos.y+i,pos.z);
                        this.level.setBlockAndUpdate(blockPos,RandomLibs.ores2[i].defaultBlockState());
                    }
                }
                else if(ran3==35){
                    if (RandomLibs.items != null) {
                        for(Item item:RandomLibs.items){
                            this.level.addFreshEntity(new ItemEntity(this.level,pos.x,pos.y,pos.z,item.getDefaultInstance()));
                        }
                    }
                }
                else if(ran3==36){
                    if (RandomLibs.blocks != null) {
                        for(int i=0;i<RandomLibs.blocks.length;i++){
                            BlockPos blockPos = new BlockPos(pos.x,pos.y+i,pos.z);
                            this.level.setBlockAndUpdate(blockPos,RandomLibs.blocks[i].defaultBlockState());
                        }
                    }
                }
                else if(ran3==37){
                    if (RandomLibs.enchantments != null) {
                        for(int i=0;i<RandomLibs.enchantments.length;i++){
                            ItemStack itemStack = Items.ENCHANTED_BOOK.getDefaultInstance();
                            itemStack.enchant(RandomLibs.enchantments[i],rand.nextInt(1,126));
                            ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                            this.level.addFreshEntity(item);
                        }
                    }
                }
                else if(ran3==38){
                    ItemStack itemStack = Items.NETHERITE_SWORD.getDefaultInstance();
                    itemStack.enchant(Enchantments.SHARPNESS,126);
                    ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                    this.level.addFreshEntity(item);
                }
                else if(ran3==39){
                    if(rand.nextBoolean()){
                        ItemStack itemStack = Items.NETHERITE_AXE.getDefaultInstance();
                        itemStack.enchant(Enchantments.BLOCK_EFFICIENCY,126);
                        ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                        this.level.addFreshEntity(item);
                    }
                    else{
                        ItemStack itemStack = Items.NETHERITE_PICKAXE.getDefaultInstance();
                        itemStack.enchant(Enchantments.BLOCK_EFFICIENCY,126);
                        itemStack.enchant(Enchantments.BLOCK_FORTUNE,126);
                        ItemEntity item = new ItemEntity(this.level,pos.x,pos.y,pos.z,itemStack);
                        this.level.addFreshEntity(item);
                    }
                }
                else if(ran3==40){
                    for(int i=0;i<250;i++){
                        Entity entity = EntityType.CHICKEN.create(this.level);
                        if (entity != null) {
                            entity.moveTo(pos);
                        }
                        if (entity != null) {
                            this.level.addFreshEntity(entity);
                        }
                    }
                }
                else if(ran3==41){
                    if (RandomLibs.blocks != null) {
                        for(int i=0;i<RandomLibs.blocks.length;i++){
                            if(RandomLibs.blocks[i] instanceof SkullBlock){
                                BlockPos blockPos = new BlockPos(pos.x,pos.y+i,pos.z);
                                this.level.setBlockAndUpdate(blockPos,RandomLibs.blocks[i].defaultBlockState());
                            }
                        }
                    }
                }
                else {
                    if(rand.nextBoolean()){
                        LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT,this.level);
                        lightningBolt.moveTo(pos);
                        this.level.addFreshEntity(lightningBolt);
                    }
                }
            }
            else{
                if(rand.nextBoolean()){
                    LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT,this.level);
                    lightningBolt.moveTo(pos);
                    this.level.addFreshEntity(lightningBolt);
                }
            }
        }
        this.level.broadcastEntityEvent(this, (byte)3);
        this.discard();
    }
}
