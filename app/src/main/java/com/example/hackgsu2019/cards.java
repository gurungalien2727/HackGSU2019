package com.example.hackgsu2019;

public class cards {


    private String imageUrl;
    private  String question;
    private String category;
    private int questionId;
    public cards(){

    }

    public cards(String imageUrl,String question,String category,int questionId){

        this.imageUrl=imageUrl;
        this.question=question;
        this.category=category;
        this.questionId=questionId;
    }
    public int getQuestionId(){
        return questionId;
    }

    public void setquestionId(int questionId){
        this.questionId=questionId;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category=category;
    }

    public String getImageId(){
        return imageUrl;
    }

    public void setImageId(String imageUrl){
        this.imageUrl=imageUrl;
    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question=question;
    }

}
