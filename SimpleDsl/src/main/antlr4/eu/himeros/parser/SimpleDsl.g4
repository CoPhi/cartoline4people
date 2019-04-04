grammar SimpleDsl;

doc: figure+;
figure: head figDesc;
head: HEAD_ATTR text;
figDesc: FIG_DESC_ATTR text;
text: SPAN+;
HEAD_ATTR: 'titolo:';
FIG_DESC_ATTR: 'descrizione:';
SPAN: [\u0021-\uFFFF]+;
WS: (' '|'\n'|EOF)->skip;
