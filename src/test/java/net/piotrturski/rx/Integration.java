package net.piotrturski.rx;

import com.github.davidmoten.rx.jdbc.Database;
import io.reactivex.netty.RxNetty;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.rx.ReactiveCamel;
import org.glassfish.jersey.client.rx.rxjava.RxObservable;
import org.json.JSONObject;
import org.junit.Test;
import rx.Observable;

import javax.ws.rs.core.Response;
import java.nio.charset.Charset;

public class Integration {

    @Test
    public void test1_rx_netty_client() throws Exception {

//        docker run --rm -p 5000:5000 training/webapp python app.py
//        RxNetty.createHttpGet("http://localhost:5000/")
        RxNetty.createHttpGet("http://api.nbp.pl/api/cenyzlota/last/30/?format=json")
                .flatMap(r -> r.getContent())
                .map(b -> b.toString(Charset.defaultCharset()))
                ;
    }

    @Test
    public void test1_jersery_client() throws Exception {

        //        docker run --rm -p 5000:5000 training/webapp python app.py

        Observable<Response> responseObservable = RxObservable.newClient()
//                .target("http://localhost:5000/")
                .target("https://api.github.com/repos/piotrturski/zohhak")
                .request()
                .rx()
                .get();

        responseObservable
                .map(resp -> resp.readEntity(String.class))
                .map(JSONObject::new)
                .map(json -> json.get("description"))
                ;
    }

    @Test
    public void test2_camel() throws Exception {
        new ReactiveCamel(new DefaultCamelContext())
                .toObservable("file:/tmp/rx-train/?noop=true")
                ;
    }

    @Test
    public void test3_postgres() throws Exception {
//        docker run --rm -p 5432:5432 postgres:9.6.1

//        jdbc:postgresql://host:port/database
        Database.from("jdbc:postgresql:postgres?user=postgres") //fromDataSource on production
                .select("select 7")
                .get(rs -> "returned: "+rs.getInt(1))
                ;

    }
}
