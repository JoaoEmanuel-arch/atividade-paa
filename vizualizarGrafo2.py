import networkx as nx
import matplotlib.pyplot as plt

G = nx.DiGraph()

G.add_nodes_from(["A","B","C","D","E","F","G","H"])

arestas = [
    # Comunidade 1
    ("A","B",0.91),
    ("B","C",0.85),
    ("C","D",0.78),
    ("A","C",0.66),
    ("B","D",0.44),

    # Comunidade 2
    ("E","F",0.87),
    ("F","G",0.93),
    ("G","H",0.82),
    ("E","G",0.59),
    ("F","H",0.48),

    ("C","F",0.22),
    ("B","E",0.17),
    ("D","G",0.12),
    ("A","E",0.10),
    ("H","D",0.33),
    ("G","B",0.27),
    ("F","A",0.19),
    ("E","C",0.15)
]

for u,v,w in arestas:
    G.add_edge(u, v, weight=w)

pos = nx.spring_layout(G, seed=42)

nx.draw_networkx_nodes(G, pos, node_size=800, node_color="lightblue")
nx.draw_networkx_labels(G, pos, font_size=10, font_weight="bold")
nx.draw_networkx_edges(G, pos, arrowstyle="->", arrowsize=20, width=2)

edge_labels = {(u, v): f"{d['weight']:.2f}" for u, v, d in G.edges(data=True)}
nx.draw_networkx_edge_labels(G, pos, edge_labels=edge_labels, font_color="red")

plt.title("Grafo 2 - Duas comunidades com ligações fracas")
plt.axis("off")
plt.show()
