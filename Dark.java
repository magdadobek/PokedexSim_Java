public interface Dark {
    static double[] weakness() {
        double[] weaknesses = new double[18];
        weaknesses[0] = 1; //normal
        weaknesses[1] = 1; //fire
        weaknesses[2] = 2; //fighting
        weaknesses[3] = 1; //water
        weaknesses[4] = 1; //flying
        weaknesses[5] = 1; //grass
        weaknesses[6] = 1; //poison
        weaknesses[7] = 1; //electric
        weaknesses[8] = 1; //ground
        weaknesses[9] = 0; //psychic
        weaknesses[10] = 1; //rock
        weaknesses[11] = 1; //ice
        weaknesses[12] = 2; //bug
        weaknesses[13] = 1; //dragon
        weaknesses[14] = 0.5; //ghost
        weaknesses[15] = 0.5; //dark
        weaknesses[16] = 1; //steel
        weaknesses[17] = 1; //fairy
        return weaknesses;
    }
}

