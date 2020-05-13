package com.example.calculator.utility;


import androidx.annotation.NonNull;

import com.example.calculator.adapter.HistoryAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class dbMiddleware {
    private String inputExpr;
    private String result;
    private String calcType;
    private Date timeStored;

    public dbMiddleware() {

    }

    public dbMiddleware(String _inputExpr, String _result) {
        inputExpr = _inputExpr;
        result = _result;

    }

    public dbMiddleware(String _inputExpr, String _result, String _calcType) {
        inputExpr = _inputExpr;
        result = _result;
        calcType = _calcType;
        timeStored = Calendar.getInstance().getTime();
    }

    public String getInputExpr() {
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

//    private String formatDate(String dateStr) {
//        try {
//            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = fmt.parse(dateStr);
//            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
//            return fmtOut.format(date);
//        } catch (ParseException e) {
//
//        }
//
//        return "";
//    }


    //This method will parse json data

//    private String parseDataToJson() {
//
//        String word = getInputExpr() + "=" + getResult();
//
//        return word;
//
//    }


    public void writeDB() {
        FirebaseFirestore database;
        //Firebase
        database = FirebaseFirestore.getInstance();
        CollectionReference Histories = database.collection("History");
        DocumentReference History = Histories.document(timeStored.toString());
        History.set(this);


        FirebaseDatabase dbFirebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = dbFirebaseDatabase.getReference("Calculator");


        Map<String, dbMiddleware> map = new HashMap<>();

        System.out.println(map.toString());
//        map.put(getInputExpr(), getResult());
        map.put(getTimeStored().toString(), new dbMiddleware(getInputExpr(), getResult()));

//        myRef.child(getTimeStored().toString()).setValueAsync(new )

        Gson gson = new Gson();

        String jsonText = gson.toJson(map.toString());



//        System.out.println(map.toString());
//
//        System.out.println(jsonText);
//
//
//        jsonText = map.toString();

//        myRef.setValue(jsonText);


    }

//    public void writeDB() {
//        String userId = "1";
//        dbMiddleware middleware = new dbMiddleware(getInputExpr(), getResult());
//        reference = FirebaseDatabase.getInstance().getReference();
//        reference.child("Result").child(userId).setValue(middleware);
//
//    }

}
