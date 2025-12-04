import networkx as nx
import matplotlib.pyplot as plt

# Criar grafo direcionado
G = nx.DiGraph()

# Adicionar nós
G.add_nodes_from(["A", "B", "C", "D", "E", "F", "G", "H"])

# Adicionar arestas com pesos
Arestas = [
    ("A", "B", 0.80),
    ("A", "G", 0.50),
    ("A", "F", 0.08),
    ("A", "C", 0.22),
    ("B", "C", 0.72),
    ("B", "G", 0.18),
    ("C", "D", 0.68),
    ("C", "G", 0.86),
    ("D", "C", 0.40),
    ("E", "A", 0.91),
    ("E", "B", 0.70),
    ("E", "F", 0.83),
    ("E", "H", 0.16),
    ("F", "C", 0.62),
    ("F", "G", 0.58),
    ("F", "H", 0.30),
    ("G", "D", 0.90),
    ("G", "H", 0.40),
    ("H", "D", 0.20),
    ("H", "A", 0.25)
]

for origem, destino, peso in arestas:
    G.add_edge(origem, destino, weight=peso)

# Layout visual
pos = nx.spring_layout(G, seed=42)

# Desenhar nós
nx.draw_networkx_nodes(G, pos, node_size=800, node_color="lightblue")

# Desenhar nomes dos nós
nx.draw_networkx_labels(G, pos, font_size=10, font_weight="bold")

# Desenhar arestas
nx.draw_networkx_edges(G, pos, arrowstyle="->", arrowsize=20, width=2)

# Mostrar pesos nas arestas
edge_labels = {(u, v): f"{d['weight']:.2f}" for u, v, d in G.edges(data=True)}
nx.draw_networkx_edge_labels(G, pos, edge_labels=edge_labels, font_color="red")

# Mostrar
plt.title("Grafo 1 - Rede com centro forte e caminhos encadeados")
plt.axis("off")
plt.show()

