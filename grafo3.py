import networkx as nx
import matplotlib.pyplot as plt

G = nx.DiGraph()

G.add_nodes_from(["A","B","C","D","E","F","G","H"])

Arestas = [
    ("A","B",0.92),
    ("A","C",0.88),
    ("A","D",0.80),

    ("B","E",0.95),
    ("B","F",0.91),
    ("B","G",0.89),

    ("C","F",0.93),
    ("C","H",0.82),

    ("D","G",0.90),
    ("D","H",0.84),

    ("E","A",0.97),
    ("E","C",0.94),

    ("F","D",0.89),
    ("F","H",0.78),

    ("G","A",0.96),
    ("G","E",0.87),

    ("H","B",0.91),
    ("H","F",0.76)
]

for u,v,w in arestas:
    G.add_edge(u, v, weight=w)

pos = nx.spring_layout(G, seed=42)

nx.draw_networkx_nodes(G, pos, node_size=800, node_color="lightblue")
nx.draw_networkx_labels(G, pos, font_size=10, font_weight="bold")
nx.draw_networkx_edges(G, pos, arrowstyle="->", arrowsize=20, width=2)

edge_labels = {(u, v): f"{d['weight']:.2f}" for u, v, d in G.edges(data=True)}
nx.draw_networkx_edge_labels(G, pos, edge_labels=edge_labels, font_color="red")

plt.title("Grafo 3 - Rede densa com pesos altos")
plt.axis("off")
plt.show()
