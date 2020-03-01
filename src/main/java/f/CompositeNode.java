package f;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CompositeNode extends Node implements ICompositeNode {
    private List<INode> nodes;

    public CompositeNode(String code, String renderer) {
        super(code, renderer);
        nodes = new ArrayList<>();
    }
    
    public void add(Node node){
        if(nodes.contains(node))
            throw new IllegalArgumentException(node+" exists in "+ this+ "\n");
        nodes.add(node);   
    }
    public void remove(Node node){
        nodes.remove(node);
    }
    
    @Override
    public List<INode> getNodes() {
        return nodes;
    }

    @Override
    public Stream<INode> toStream() {
        return Stream.concat(
                super.toStream(),
                nodes.stream().flatMap(INode::toStream)
        );
    }
   
}