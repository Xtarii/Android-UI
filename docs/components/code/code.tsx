import { Prism as SyntaxHighLighter } from "react-syntax-highlighter"
import { oneDark } from "react-syntax-highlighter/dist/esm/styles/prism"
import { ReactElement } from "react"

/**
 * Code block Element
 */
export default function CodeBlock({ children, language = "kotlin" } : { children: string, language?: string }) : ReactElement {
    return(<SyntaxHighLighter language={language} style={oneDark}>{children}</SyntaxHighLighter>)
}
