package sg.edu.np.mad.mad_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    ArrayList<Task> data;
    public TaskAdapter(ArrayList<Task> input){
        data = input;
    }


    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.taskview, parent, false);
        TaskViewHolder viewHolder = new TaskViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        String name = data.get(position).getName();

        holder.taskName.setText(name);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
