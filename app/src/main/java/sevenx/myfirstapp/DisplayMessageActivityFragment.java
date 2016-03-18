package sevenx.myfirstapp;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A placeholder fragment containing a simple view.
 */
public class DisplayMessageActivityFragment extends Fragment {
    public interface DisplayMessageListener {
        public String getMessage();
    }
    private TextView messageView;
    public DisplayMessageActivityFragment() {
    }
    private DisplayMessageListener messageListener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            messageListener = (DisplayMessageListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(messageListener.toString() + " must implement DisplayMessageListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_message, container, false);
        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.messageContainer);
        messageView = new TextView(layout.getContext());
        messageView.setTextSize(40);
        layout.addView(messageView);
        return view;
    }
    public void onResume() {
        super.onResume();
        messageView.setText(messageListener.getMessage());
    }
}
