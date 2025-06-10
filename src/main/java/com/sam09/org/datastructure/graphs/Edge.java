package com.sam09.org.datastructure.graphs;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Edge {

    @NonNull
    int data;
    int position;
    @NonNull
    @Setter(AccessLevel.NONE)
    Vertex vertex1;
    @NonNull
    @Setter(AccessLevel.NONE)
    Vertex vertex2;
}
