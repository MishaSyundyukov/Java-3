import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;

public class ClientAdapterHandler extends
        ChannelInboundMessageHandlerAdapter<String> {

    @Override
    public void messageReceived(ChannelHandlerContext context, String message)
            throws Exception {
        System.out.println(message);
        if (message.equals("quit"))
            throw new ServerEndedException("Server is closed");
    }

    @Override
    public void channelRead(ChannelHandlerContext arg0, Object arg1)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext arg0)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext arg0)
            throws Exception {
        // TODO Auto-generated method stub

    }

}
