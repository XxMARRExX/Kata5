package http.kata5.software.ulpgc.es;

import org.eclipse.jetty.util.ajax.JSON;

public interface Command {

    Output execute (Input input);

    interface Input {
        String get(String key);
    }

    interface Output{
        String result();
        int response();
    }

}
