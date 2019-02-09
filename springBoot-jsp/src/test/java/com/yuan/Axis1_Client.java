package com.yuan;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.message.MessageElement;
import org.apache.axis.types.Schema;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2019-01-15
 * Time: 15:13
 * description:
 **/
public class Axis1_Client {
    /**
     * 使用dom4j解析数据
     */
    @Test
    public void axisWSInvoke(){
        String dataSetDataStr = axisInvokeNetDataSetData();
        //System.out.println(dataSetDataStr);
        if(dataSetDataStr != null){
            try {
                Document doc = DocumentHelper.parseText(dataSetDataStr);// 将字符串转为XML
                Element root = doc.getRootElement();// 获取根节点
                Iterator iterator =  root.elementIterator("Zone");//迭代节点
                String id,zone;
                while(iterator.hasNext()){
                  Element element = (Element) iterator.next();
                  id = element.elementTextTrim("ID");//取出Zone节点下的ID元素的值
                  zone = element.elementTextTrim("Zone");//取出Zone节点下的Zone元素的值
                    System.out.println("Id:"+id+"=============================Zone:"+zone);
                }
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 调用.Net写的返回值为DataSet类型的WebService服务
     * @return
     */
    public String axisInvokeNetDataSetData(){
        Service service = new Service();
        String strXml = null;
        Call call = null;
        try {
            call = (Call) service.createCall();
            call.setTargetEndpointAddress(new URL("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx"));//WSURL，注意不要带?wsdl
            //调用方法方法前设置相关参数
            call.setOperationName(new QName("http://WebXml.com.cn/", "getSupportDataSet"));
            call.setReturnType(XMLType.XSD_SCHEMA);//返回类型，这里一定要传入 XMLType.XSD_SCHEMA 类型
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("http://WebXml.com.cn/getSupportDataSet");//soapAction
            Object obj = call.invoke((Object[]) null);
            Schema schema = (Schema) obj;
            MessageElement[] messageElements = schema.get_any();
            List messageHead = messageElements[0].getChildren();//消息头,DataSet对象
            List messageBody = messageElements[1].getChildren();//消息体信息,DataSet对象,最终需要解析的数据
            if (messageBody.size() > 0) {
                String head = messageHead.get(0).toString();//消息头,DataSet对象
                String diffgr = messageBody.get(0).toString();//消息体的字符串形式
                strXml = diffgr;
                System.out.println("head:\n"+head);
                System.out.println("diffgr:\n" + diffgr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strXml;
    }

}
