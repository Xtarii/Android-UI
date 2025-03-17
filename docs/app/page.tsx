import CodeBlock from "@/components/code/code";
import { Box, Typography } from "@mui/material";
import Link from "next/link";

export default function Home() {
    return (<div>
        <main>
            <Link href={"./base/"}>
                <p>Documentation : <code>Base functionality</code></p>
            </Link>



            <Link href={"./clickables/"}>
                <p>Documentation : <code>Clickable Components</code></p>
            </Link>



            <Typography variant="h4">Getting Started</Typography>
            <Box>
                <Typography variant="h6">Adding <code>AUI</code> to a project</Typography>
                <Typography>Maven</Typography>
                <CodeBlock language="html">{
                    "<dependency>\n" +
                        "\t<groupId>org.android.ui</groupId>\n" +
                        "\t<artifactId>aui</artifactId>\n" +
                        "\t<version>1.0.1a3</version>\n" +
                    "</dependency>\n"
                }</CodeBlock>
            </Box>
        </main>
        <footer>
        </footer>
    </div>)
}
