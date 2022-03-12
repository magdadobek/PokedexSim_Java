public interface Rock {
    static double[] weakness() {
        double[] weaknesses = new double[18];
        weaknesses[0] = 0.5; //normal
        weaknesses[1] = 0.5; //fire
        weaknesses[2] = 2; //fighting
        weaknesses[3] = 2; //water
        weaknesses[4] = 0.5; //flying
        weaknesses[5] = 2; //grass
        weaknesses[6] = 0.5; //poison
        weaknesses[7] = 1; //electric
        weaknesses[8] = 2; //ground
        weaknesses[9] = 1; //psychic
        weaknesses[10] = 1; //rock
        weaknesses[11] = 1; //ice
        weaknesses[12] = 1; //bug
        weaknesses[13] = 1; //dragon
        weaknesses[14] = 1; //ghost
        weaknesses[15] = 1; //dark
        weaknesses[16] = 2; //steel
        weaknesses[17] = 1; //fairy
        return weaknesses;
    }
}

