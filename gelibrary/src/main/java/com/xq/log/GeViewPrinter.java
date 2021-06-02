package com.xq.log;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/06/02 9:59
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xq.R;

import java.util.ArrayList;
import java.util.List;

/**
 * GeViewPrinter 将log显示在界面上
 */


public class GeViewPrinter implements GeLogPrinter {
    private RecyclerView recyclerView;
    private LogAdapter adapter;
    private GeViewPrinterProvider viewProvider;

    public GeViewPrinter(Activity activity) {
        FrameLayout rootView = activity.findViewById(android.R.id.content);
        recyclerView = new RecyclerView(activity);
        adapter = new LogAdapter(LayoutInflater.from(recyclerView.getContext()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        viewProvider = new GeViewPrinterProvider(rootView, recyclerView);
    }

    /**
     * 获取ViewProvider，通过ViewProvider可以控制log视图的展示和隐藏
     *
     * @return ViewProvider
     */
    @NonNull
    public GeViewPrinterProvider getViewProvider() {
        return viewProvider;
    }

    @Override
    public void print(@NonNull GeLogConfig config, int level, String tag, @NonNull String printString) {

        // 将log展示添加到recycleView
        adapter.addItem(new GeLogMo(System.currentTimeMillis(), level, tag, printString));

        // 滚动到对应的位置
        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
    }

    private static class LogAdapter extends RecyclerView.Adapter<LogViewHolder> {

        private LayoutInflater inflater;

        private List<GeLogMo> logs = new ArrayList<>();

        LogAdapter(LayoutInflater inflater) {
            this.inflater = inflater;
        }

        void addItem(GeLogMo logItem) {
            logs.add(logItem);
            notifyItemInserted(logs.size() - 1);
        }

        @NonNull
        @Override
        public LogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.gelog_item, parent, false);
            return new LogViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(LogViewHolder holder, int position) {
            GeLogMo logItem = logs.get(position);

            int color = getHighlightColor(logItem.level);
            holder.tagView.setTextColor(color);
            holder.messageView.setTextColor(color);

            holder.tagView.setText(logItem.getFlattened());
            holder.messageView.setText(logItem.log);
        }

        /**
         * 跟进log级别获取不同的高了颜色
         *
         * @param logLevel log 级别
         * @return 高亮的颜色
         */
        private int getHighlightColor(int logLevel) {
            int highlight;
            switch (logLevel) {
                case GeLogType.V:
                    highlight = 0xffbbbbbb;
                    break;
                case GeLogType.D:
                    highlight = 0xffffffff;
                    break;
                case GeLogType.I:
                    highlight = 0xff6a8759;
                    break;
                case GeLogType.W:
                    highlight = 0xffbbb529;
                    break;
                case GeLogType.E:
                    highlight = 0xffff6b68;
                    break;
                default:
                    highlight = 0xffffff00;
                    break;
            }
            return highlight;
        }

        @Override
        public int getItemCount() {
            return logs.size();
        }
    }


    private static class LogViewHolder extends RecyclerView.ViewHolder {

        TextView tagView;
        TextView messageView;

        LogViewHolder(View itemView) {
            super(itemView);
            tagView = itemView.findViewById(R.id.tag);
            messageView = itemView.findViewById(R.id.message);
        }
    }
}
