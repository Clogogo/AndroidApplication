package com.example.calculator.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculator.R;
import com.example.calculator.utility.DbMiddleware;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class HistoryAdapter extends FirestoreRecyclerAdapter<DbMiddleware, HistoryAdapter.HistoryHolder> {

    public HistoryAdapter(@NonNull FirestoreRecyclerOptions<DbMiddleware> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull HistoryHolder historyHolder, int i, @NonNull DbMiddleware dbM) {
        historyHolder.inputExpr.setText(dbM.getInputExpr());
        historyHolder.result.setText(dbM.getResult());
        historyHolder.calcType.setText(dbM.getCalcType());
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new HistoryHolder(v);
    }

   public class HistoryHolder extends RecyclerView.ViewHolder {
        TextView inputExpr,result,calcType;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            inputExpr = itemView.findViewById(R.id.expr);
            result = itemView.findViewById(R.id.result);
            calcType = itemView.findViewById(R.id.type);
        }
    }


}
