package boe.b4.appserver.utils;

import com.sun.tools.internal.ws.wsdl.document.Message;

public class MessageService {

    public static String SendRequest(String sendMessage)
    {
        /*try
        {
            Message message;
            if (sendMessage.contains("GetQueryResult"))
            {
                message = new Message() { SendSubject = messageInfo.QueryTargetSubject };
                message.AddField(messageInfo.FieldName, sendMessage, 0);
                Message received = querytransport.SendRequest(message, Double.Parse(messageInfo.TimeOut));

                return (received == null) ? null : received.GetField(messageInfo.FieldName).Value.ToString();
            }
            else
            {
                message = new Message() { SendSubject = messageInfo.TargetSubject };
                message.AddField(messageInfo.FieldName, sendMessage, 0);

                Message received = transport.SendRequest(message, Double.Parse(messageInfo.TimeOut));

                return (received == null) ? null : received.GetField(messageInfo.FieldName).Value.ToString();
            }
        }
        catch (RendezvousException ex)
        {
            throw ex;
        }*/
        return null;
    }
}
