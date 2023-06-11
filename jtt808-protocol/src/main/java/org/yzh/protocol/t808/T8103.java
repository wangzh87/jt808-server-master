package org.yzh.protocol.t808;

import io.github.yezhihao.protostar.annotation.Field;
import io.github.yezhihao.protostar.annotation.Message;
import org.yzh.protocol.basics.JTMessage;
import org.yzh.protocol.commons.JT808;
import org.yzh.protocol.commons.transform.ParameterConverter;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author yezhihao
 * https://gitee.com/yezhihao/jt808-server
 */
@Message(JT808.设置终端参数)
public class T8103 extends JTMessage {

    @Field(length = 1, desc = "参数总数")
    private int total;
    @Field(desc = "参数项列表", converter = ParameterConverter.class)
    private Map<Integer, Object> parameters;

    public T8103() {
    }

    public T8103(Map<Integer, Object> parameters) {
        this.parameters = parameters;
        this.total = parameters.size();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Map<Integer, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<Integer, Object> parameters) {
        this.parameters = parameters;
        this.total = parameters.size();
    }

    public T8103 addParameter(Integer key, Object value) {
        if (parameters == null)
            parameters = new TreeMap();
        parameters.put(key, value);
        total = parameters.size();
        return this;
    }
}