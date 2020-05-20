package sg.edu.np.mad.mad_recyclerview;

import android.text.Layout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    public TextView taskName;
    public CheckBox checkBox;
    public View taskView;
    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        taskName = itemView.findViewById(R.id.taskviewname);
        checkBox = itemView.findViewById(R.id.check);
        taskView = (View) itemView.findViewById(R.id.taskrow);
    }
}
