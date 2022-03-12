public interface Bug {
    static double[] weakness() {
        double[] weaknesses = new double[18];
        weaknesses[0] = 1; //normal
        weaknesses[1] = 2; //fire
        weaknesses[2] = 0.5; //fighting
        weaknesses[3] = 1; //water
        weaknesses[4] = 2; //flying
        weaknesses[5] = 0.5; //grass
        weaknesses[6] = 1; //poison
        weaknesses[7] = 1; //electric
        weaknesses[8] = 0.5; //ground
        weaknesses[9] = 1; //psychic
        weaknesses[10] = 2; //rock
        weaknesses[11] = 1; //ice
        weaknesses[12] = 1; //bug
        weaknesses[13] = 1; //dragon
        weaknesses[14] = 1; //ghost
        weaknesses[15] = 1; //dark
        weaknesses[16] = 1; //steel
        weaknesses[17] = 1; //fairy
        return weaknesses;
    }
}

