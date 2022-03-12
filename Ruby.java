public class Ruby extends Gen3{
    String description;
    static String gameVersion = "Ruby";

    public Ruby() {}

    public Ruby(String name, int hp, int attack, int defense, int speed, int type1, String description, String picturePath) {
        Ruby pokemon = new Ruby();
        pokemon.name =name;
        pokemon.hp =hp;
        pokemon.attack =attack;
        pokemon.defense =defense;
        pokemon.speed =speed;
        pokemon.type1 =type1;
        pokemon.weaknesses=weakness(type1);
        pokemon.description = description;
        pokemon.picturePath=picturePath;
        pokedex.add(pokemon);
    }

    public Ruby(String name, int hp, int attack, int defense, int speed, int type1, int type2, String description, String picturePath) {
        Ruby pokemon = new Ruby();
        pokemon.name =name;
        pokemon.hp =hp;
        pokemon.attack =attack;
        pokemon.defense =defense;
        pokemon.speed =speed;
        pokemon.type1 =type1;
        pokemon.type2 =type2;
        pokemon.weaknesses=weakness(type1,type2);
        pokemon.description =description;
        pokemon.picturePath=picturePath;
        pokedex.add(pokemon);
    }

    public Ruby(String text){
        String[] data = text.split("\n");
        Pokemon.add_types_weaknesses();
        Ruby pokemon = new Ruby();
        pokemon.name=data[0];
        pokemon.hp=Integer.parseInt(data[1]);
        pokemon.attack=Integer.parseInt(data[2]);
        pokemon.defense=Integer.parseInt(data[3]);
        pokemon.speed=Integer.parseInt(data[4]);
        if(data[5].contains("/")){
            String[] types = data[5].split("/");
            pokemon.type1=Integer.parseInt(types[0]);
            pokemon.type2=Integer.parseInt(types[1]);
            pokemon.weaknesses=weakness(pokemon.type1,pokemon.type2);
        }
        else {
            pokemon.type1=Integer.parseInt(data[5]);
            pokemon.weaknesses=weakness(pokemon.type1);
        }
        pokemon.description=data[9];
        pokemon.picturePath=data[10];
        pokedex.add(pokemon);
    }

    @Override
    public String toString(){
        String to_return = this.name+"\n"+this.hp+"\n"+this.attack+"\n"+this.defense+"\n"+this.speed+"\n";
        if(this.type2==18) to_return = to_return.concat(type1+"");
        else to_return = to_return.concat(type1+"/"+type2);
        to_return = to_return.concat("\n"+ location);
        to_return = to_return.concat("\n"+ generation);
        to_return = to_return.concat("\n"+ gameVersion);
        to_return = to_return.concat("\n"+ this.description);
        to_return = to_return.concat("\n"+ this.picturePath+"\n");
        return to_return;
    }
}
