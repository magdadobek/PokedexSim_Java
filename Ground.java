public interface Ground {
    static double[] weakness() {
        double[] weaknesses = new double[18];
        weaknesses[0] = 1; //normal
        weaknesses[1] = 1; //fire
        weaknesses[2] = 1; //fighting
        weaknesses[3] = 2; //water
        weaknesses[4] = 1; //flying
        weaknesses[5] = 2; //grass
        weaknesses[6] = 0.5; //poison
        weaknesses[7] = 0; //electric
        weaknesses[8] = 1; //ground
        weaknesses[9] = 1; //psychic
        weaknesses[10] = 0.5; //rock
        weaknesses[11] = 2; //ice
        weaknesses[12] = 1; //bug
        weaknesses[13] = 1; //dragon
        weaknesses[14] = 1; //ghost
        weaknesses[15] = 1; //dark
        weaknesses[16] = 1; //steel
        weaknesses[17] = 1; //fairy
        return weaknesses;
    }
}

