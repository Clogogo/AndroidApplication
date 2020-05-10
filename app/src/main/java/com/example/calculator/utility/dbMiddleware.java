package com.example.calculator.utility;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class dbMiddleware {
    private String inputExpr;
    private String result;
    private String calcType;
    private Date timeStored;



    public dbMiddleware(){

    }

    public dbMiddleware(String _inputExpr, String _result, String _calcType){
        inputExpr = _inputExpr;
        result = _result;
        calcType = _calcType;
        timeStored = Calendar.getInstance().getTime();
    }

    public String getInputExpr(){
        return inputExpr;
    }

    public String getResult() {
        return result;
    }

    public String getCalcType() {
        return calcType;
    }

    public Date getTimeStored() {
        return timeStored;
    }

    public void writeDB(){
//        FirebaseFirestore database;
//        //Firebase
//        database = FirebaseFirestore.getInstance();
//        CollectionReference Histories = database.collection("History");
//        DocumentReference History = Histories.document(timeStored.toString());
//        History.set(this);

        FirebaseDatabase dbFirebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = dbFirebaseDatabase.getReference("Calculator");

        Map<String, Object> map = new HashMap<>();
        map.put("timeStored", timeStored.toString());
        map.put("CalculationType", calcType);
        map.put("Input", inputExpr);
        map.put("Result", result);

        myRef.setValue(map);


    }

    //This method will parse json data
    private void parseDataToJson(){

    }


}
