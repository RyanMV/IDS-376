package com.example.todowork.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todowork.databinding.TaskLayoutBinding
import com.example.todowork.fragment.HomeFragmentDirections
import com.example.todowork.model.TaskEntity

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>()  {

    class TaskViewHolder(val itemBinding: TaskLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root)
    private val differCallback = object : DiffUtil.ItemCallback<TaskEntity>() {
        override fun areItemsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.description == newItem.description &&
                    oldItem.title == newItem.title &&
                    oldItem.dueDate == newItem.dueDate &&
                    oldItem.priority == newItem.priority &&
//                    oldItem.isCompleted == newItem.isCompleted &&
//                    oldItem.assignTo == newItem.assignTo &&
                    oldItem.state == newItem.state
        }

        override fun areContentsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
           return oldItem == newItem
        }

    }
        val differ = AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            TaskLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = differ.currentList[position]
        holder.itemBinding.taskDesc.text = currentTask.description
        holder.itemBinding.taskTitle.text = currentTask.title

        holder.itemView.setOnClickListener{
            val direction = HomeFragmentDirections.actionHomeFragmentToEditTaskFragment(currentTask)
            it.findNavController().navigate(direction)
        }
    }

}
