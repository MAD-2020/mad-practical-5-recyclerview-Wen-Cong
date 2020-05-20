package sg.edu.np.mad.mad_recyclerview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    ArrayList<Task> data;
    private Activity activityMain;
    public TaskAdapter(ArrayList<Task> input, Activity parentActivity){
        data = input;
        activityMain = parentActivity;
    }


    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.taskview, parent, false);
        TaskViewHolder viewHolder = new TaskViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TaskViewHolder holder, int position) {
        String name = data.get(position).getName();
        final Task t = data.get(position);
        holder.taskName.setText(name);
        holder.checkBox.setChecked(t.getCheck());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                t.setCheck(isChecked);
            }
        });
        holder.taskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteDialogBox(t);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private void showDeleteDialogBox(final Task task){
        AlertDialog.Builder builder = new AlertDialog.Builder(activityMain);
        builder.setTitle("Delete");
        builder.setMessage("Are you sure you want to delete this task?");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int pos = data.indexOf(task);
                data.remove(pos);
                notifyItemRemoved(pos);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}


