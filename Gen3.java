public class Gen3 extends Pokemon {
    static String location = "Hoenn";
    static int generation = 3;

    public Gen3(){}

    public Gen3(String name, int hp, int attack, int defense, int speed, int type1, String picturePath) {
        Gen3 pokemon = new Gen3();
        pokemon.name =name;
        pokemon.hp =hp;
        pokemon.attack =attack;
        pokemon.defense =defense;
        pokemon.speed =speed;
        pokemon.type1 =type1;
        pokemon.weaknesses=weakness(type1);
        pokemon.picturePath=picturePath;
        pokedex.add(pokemon);
    }

    public Gen3(String name, int hp, int attack, int defense, int speed, int type1, int type2, String picturePath) {
        Gen3 pokemon = new Gen3();
        pokemon.name =name;
        pokemon.hp =hp;
        pokemon.attack =attack;
        pokemon.defense =defense;
        pokemon.speed =speed;
        pokemon.type1 =type1;
        pokemon.type2 =type2;
        pokemon.weaknesses=weakness(type1,type2);
        pokemon.picturePath=picturePath;
        pokedex.add(pokemon);
    }

    @Override
    public String toString(){
        String to_return = "Name: "+this.name+"\nHP: "+this.hp+"\nAttack: "+this.attack+"\nDefense: "+this.defense+"\nSpeed: "+this.speed+"\nType/s: ";
        if(this.type2==18) to_return = to_return.concat(types.get(this.type1));
        else to_return = to_return.concat(types.get(this.type1)+"/"+types.get(this.type2));
        to_return = to_return.concat("\nLocation: "+ location);
        to_return = to_return.concat("\nGeneration: "+ generation+"\n");
        return to_return;
    }
}
