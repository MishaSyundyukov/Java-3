 EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
        Bootstrap b = new Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);
        b.handler(new ClientInitializer());

        Channel ch = b.connect(host, port).sync().channel();
        ChannelFuture f = ch.writeAndFlush("Some message");

    } finally {
        workerGroup.shutdownGracefully();
    }
///////////////////////////////////
public class ClientInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        p.addLast("decoder", new InputDecoder());
        p.addLast("encoder", new OutputEncoder());
        p.addLast("handler", new ClientHandler());
        p.addLast("httpExceptionHandler", new ClientExceptionHandler());
    }
}
///////////////////////////////////
public class ClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}
