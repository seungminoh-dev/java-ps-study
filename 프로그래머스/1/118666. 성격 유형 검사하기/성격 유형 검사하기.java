class Solution {
    public String solution(String[] survey, int[] choices) {
        int rscore = 0; //T
        int cscore = 0; //F
        int jscore = 0; //M 
        int ascore = 0; //N
        
        for(int i=0;i<survey.length;i++){
            String surv = survey[i];
            int score = choices[i]-4;
            if(surv.equals("TR") || surv.equals("RT")){
                rscore+=surv.equals("TR") ? score : -score;
            }else if(surv.equals("FC") || surv.equals("CF")){
                cscore+=surv.equals("FC") ? score : -score;
            }else if(surv.equals("MJ") || surv.equals("JM")){
                jscore+=surv.equals("MJ") ? score : -score;
            }else if(surv.equals("AN") || surv.equals("NA")){
                ascore+=surv.equals("NA") ? score : -score;
            }
        }
        String answer = new StringBuilder().append(rscore>=0?"R":"T").append(cscore>=0?"C":"F").append(jscore>=0?"J":"M").append(ascore>=0?"A":"N").toString();
        return answer;
    }
}